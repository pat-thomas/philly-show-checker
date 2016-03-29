name := "philly-show-checker-service"

version := "0.1"

scalaVersion := "2.11.8"

//scalaSource in Compile := baseDirectory.value / "src"

mainClass in (Compile, run) := Some("Server")
