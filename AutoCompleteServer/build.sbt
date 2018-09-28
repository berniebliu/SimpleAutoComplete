
name := "auto-complete"

version := "0.0.1"

organization := "com.autocomplete"

scalaVersion := "2.12.6"

val DW_VERSION = "1.3.5"
val JETTY_VERSION =  "9.4.12.v20180830"
val JERSEY_VERSION = "2.25.1"

crossPaths := false
autoScalaLibrary := false

// enforce Maven compatibility
publishMavenStyle := true

mainClass in (Compile, run) := Some("com.autocomplete.init.AutoCompleteApplication")
mainClass in (Compile, packageBin) := Some("com.autocomplete.init.AutoCompleteApplication")

libraryDependencies ++= Seq(
  "io.dropwizard" % "dropwizard-core" % DW_VERSION,
  "org.glassfish.jersey.media" % "jersey-media-multipart" % JERSEY_VERSION,
  "org.eclipse.jetty" % "jetty-client" % JETTY_VERSION
)