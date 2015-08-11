package scalania.docker2

import akka.actor.{Actor, ActorContext}
import spray.httpx.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._
import spray.routing.HttpService

class WeatherServiceActor extends Actor with HttpService {
  override implicit def actorRefFactory: ActorContext = context

  override def receive: Receive = runRoute {
    compressResponseIfRequested() {
      route
    }
  }

  implicit val weatherInfoFormat = jsonFormat1(WeatherInfo)

  val route = pathEndOrSingleSlash {
    get {
      parameter('city) { city =>
        complete {
          city.toLowerCase match {
            case "warsaw" =>
              Some(WeatherInfo(30.0))
            case "prague" =>
              Some(WeatherInfo(32.5))
            case "tallinn" =>
              Some(WeatherInfo(25.1))
            case _ =>
              Option.empty[WeatherInfo]
          }
        }
      }
    }
  }
}
