package com.tarasovs.civetweb

import Bindings._
import Bindings.implicits._
import CivetWeb._
import scala.scalanative.native._
import scala.scalanative.native.stdlib._
import scala.scalanative.posix.pthread._
import scala.scalanative.posix.sys.types._
import scalaz.Codensity
import scalaz.effect.IO
import scalaz.effect.IORef

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

  class Context(underlying: Ptr[struct_mg_context]) {

    private var handlers: Vector[Context.Handler] = Vector.empty

    private[CivetWeb] def stop: IO[Unit] = IO {
      mg_stop(underlying)
    }

    def setRequestHandler(uri: CString)(handler: Context.Handler): IO[Unit] =
      IO {
        handlers = handlers :+ handler
        
        mg_set_request_handler(
          underlying,
          uri,
          Context.handle,
          handler.cast[Ptr[Byte]]
        )

      }

     def loop: IO[Unit] = IO {
       import Context._
       pthread_mutex_lock(GlobalState.mutex)
       while(true) {
        pthread_cond_wait(
          GlobalState.controlPassed,
          GlobalState.mutex
        )
        val connection = new Connection(GlobalState.connection)
        GlobalState.result = GlobalState.handler(connection).unsafePerformIO()
        pthread_cond_signal(GlobalState.controlPassed)
       }
       pthread_mutex_unlock(GlobalState.mutex)
     }

  }
  object Context {

    object GlobalState {

      private[Context] val mutex: Ptr[pthread_mutex_t] =
        malloc(pthread_mutex_t_size)
        .cast[Ptr[pthread_mutex_t]]
      pthread_mutex_init(mutex, null)

      private[Context] val controlPassed: Ptr[pthread_cond_t] =
        malloc(pthread_cond_t_size)
        .cast[Ptr[pthread_cond_t]]
      pthread_cond_init(controlPassed, null)

      private[Context] var connection: Ptr[struct_mg_connection] = null
      private[Context] var handler: Handler = null
      private[Context] var result: Int = 0
    }

    type Handler = Connection => IO[Int]

    private[CivetWeb] val start = IO {
      val context = mg_start(null, null, null)
      new Context(context)
    }

    private val handle: CFunctionPtr2[Ptr[struct_mg_connection], Ptr[Byte], Int] =
      CFunctionPtr.fromFunction2 { (connection, data) =>
        // WARNING: This thread is created by CivetWeb, not Scala Native!
        // We cannot allocate anything here, or we will kill Immix.
        // Note that even `println` does some allocations.
        pthread_mutex_lock(GlobalState.mutex)
        GlobalState.connection = connection
        GlobalState.handler = data.cast[Handler]
        pthread_cond_signal(GlobalState.controlPassed)
        pthread_cond_wait(GlobalState.controlPassed, GlobalState.mutex)
        pthread_mutex_unlock(GlobalState.mutex)
        GlobalState.result
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