import com.tarasovs.civetweb.Bindings._

import com.tarasovs.civetweb.CivetWeb
import scala.io.StdIn
import scala.scalanative.native._
import scalaz.Codensity
import scalaz.effect.IO
import scalaz.effect.SafeApp
import scalaz.syntax.monad._

object Main extends SafeApp {

  val program =
    for {
      _ <- IO.putStrLn("Starting...").liftM[Codensity]
      library <- CivetWeb.initLibrary
      context <- library.start
      _ <-
        context
        .setRequestHandler(c"/health") { connection =>
          connection.sendHttpOk(c"text/plain", 2) *>
          connection.printf(c"OK") as 200
        }
        .liftM[Codensity]
      _ <- IO.putStrLn("Press Ctrl-C to stop").liftM[Codensity]
      _ <- context.loop.liftM[Codensity]
    } yield ()


  override def runc: IO[Unit] =
    program.improve

}
