import org.apache.pekko
import org.apache.pekko.actor.ActorSystem
import pekko.stream.scaladsl._

import scala.concurrent.ExecutionContext.Implicits.global

object Main {
  implicit val system: ActorSystem = ActorSystem("QuickStart")
  def main(args: Array[String]): Unit = {
    val source = Source(1 to 100)
    val f = source.filter { n =>
      if (n == 50) throw new Exception("test")
      else true
    }.runWith(Sink.foreach(println(_)))

    f.failed.foreach { e =>
      println(e.getMessage)
      system.terminate() // ないと落ちない
    }
  }
}
