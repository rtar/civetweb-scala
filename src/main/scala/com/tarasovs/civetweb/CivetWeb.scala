package com.tarasovs.civetweb

import Bindings._
import CivetWeb._
import scala.scalanative.native._
import scalaz.Codensity
import scalaz.effect.IO

class CivetWeb {

  def start: Codensity[IO, Context] =
    new Codensity[IO, Context] {

      def apply[C](f: Context => IO[C]): IO[C] =
        Context.start.bracket(_.stop)(f)
        
    }

}
object CivetWeb {

  class Connection(underlying: Ptr[struct_mg_connection]) {

    def sendHttpOk(mimeType: CString, contentLength: CLongLong): IO[Int] = IO {
      mg_send_http_ok(underlying, mimeType, contentLength)
    }

    def printf(format: CString, parameters: CVararg*): IO[Int] = IO {
      mg_printf(underlying, format, parameters)
    }

  }
  object Connection {
    def apply(underlying: Ptr[struct_mg_connection]): Connection =
      new Connection(underlying)
  }

  class Context(underlying: Ptr[struct_mg_context]) {

    private[CivetWeb] def stop: IO[Unit] = IO {
      mg_stop(underlying)
    }

    def setRequestHandler(uri: CString)(handler: Connection => IO[Int]): IO[Unit] =
      IO {
        mg_set_request_handler(
          underlying,
          uri,
          Context.handleFunction,
          handler.cast[Ptr[Byte]]
        )
      }

  }
  object Context {

    private[CivetWeb] val start = IO {
      val context = mg_start(null, null, null)
      new Context(context)
    }

    private val handleFunction = CFunctionPtr.fromFunction2(handle)

    private def handle(
        connection: Ptr[struct_mg_connection],
        data: Ptr[Byte]): Int = {
      val handler = data.cast[Connection => IO[Int]]
      handler(new Connection(connection)).unsafePerformIO()
    }

  }

  def initLibrary: Codensity[IO, CivetWeb] =
    new Codensity[IO, CivetWeb] {
      
      val init = IO {
        mg_init_library(0.toUInt)
        new CivetWeb
      }
      
      def exit(library: CivetWeb) = IO {
        mg_exit_library()
      }

      def apply[C](f: CivetWeb => IO[C]): IO[C] =
        init.bracket(exit)(f)

    }
  
}