package scalania.docker2

import java.util.concurrent.TimeUnit

import com.typesafe.config.ConfigFactory

import scala.concurrent.duration.Duration

object Config {
  private val config = ConfigFactory.load().getConfig("scalania.docker2")

  val timeout = Duration(config.getDuration("timeout").toMillis, TimeUnit.MILLISECONDS)
  val crash = config.getBoolean("crash")
  val serviceName = config.getString("serviceName")
  val port = config.getInt("port")
}
