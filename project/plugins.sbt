logLevel := Level.Warn

resolvers += "spray repo" at "http://repo.spray.io"

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.3")
