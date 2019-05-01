scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "org.scalaz" %%% "scalaz-core" % "7.2.27",
  "org.scalaz" %%% "scalaz-effect" % "7.2.27"
)

// Set to false or remove if you want to show stubs as linking errors
nativeLinkStubs := true

enablePlugins(ScalaNativePlugin)