enablePlugins(JavaAppPackaging, DockerPlugin)

name := "weather-service"

version := "1.0"

scalaVersion := "2.11.7"

packageName in Docker := "betenkowski/scalania-weather-service"

version in Docker := "latest"

maintainer := "Bartłomiej Etenkowski"

dockerBaseImage := "java:8"

dockerExposedPorts := Seq(8080)

libraryDependencies ++= {
  val sprayVersion = "1.3.3"
  val akkaVersion = "2.3.9"
  Seq(
    "io.spray" %% "spray-can" % sprayVersion,
    "io.spray" %% "spray-routing" % sprayVersion,
    "io.spray" %% "spray-json" % "1.3.2",
    "io.spray" %% "spray-client" % sprayVersion,
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
    "com.typesafe" % "config" % "1.3.0"
  )
}

Revolver.settings.settings