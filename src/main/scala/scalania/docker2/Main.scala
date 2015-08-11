package scalania.docker2

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import spray.can.Http

object Main extends App {
  if (Config.crash) {
    throw new IllegalArgumentException("The configuration caused the application crash")
  }

  implicit val system = ActorSystem("on-spray-can")
  implicit val timeout = Timeout.durationToTimeout(Config.timeout)
  val service = system.actorOf(Props[WeatherServiceActor], Config.serviceName)
  IO(Http) ? Http.Bind(service, interface = "0.0.0.0", port = Config.port)
}
