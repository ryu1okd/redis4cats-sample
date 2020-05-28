import cats.effect._
import cats._
import cats.implicits._
import dev.profunktor.redis4cats.Redis
import dev.profunktor.redis4cats.effect.Log.Stdout._

object Main extends IOApp {

  def run(args: List[String]): IO[ExitCode] = {
    val key = "list2"
    Redis[IO].utf8("redis://localhost:6379").use { cmd =>
      for {
        y <- cmd.get(key)
        x <- y.fold {
          println(s"not have in redis key = $key")
          cmd.get("list")
        }(s => IO.pure(s.some))
      } yield {
        println(x)
        ExitCode.Success
      }
    }
  }
}
