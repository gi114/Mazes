name := "mazes"

version := "0.1"

scalaVersion := "2.12.0"


libraryDependencies ++= Seq(
  "org.scalamock" %% "scalamock" % "4.1.0" % Test,
  "org.scalatest" %% "scalatest" % "3.0.4" % Test,
  "org.scala-sbt" %% "compiler-bridge" % "1.1.1" % Test,
  "org.mockito" % "mockito-core" % "1.8.5" % Test,
  "au.com.bytecode" % "opencsv" % "2.4")
