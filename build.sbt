ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

val PekkoVersion = "1.0.1"

lazy val root = (project in file("."))
  .settings(
    organization := "",
    name := "PekkoExceptionSample",
    libraryDependencies ++= Seq(
      "org.apache.pekko"           %% "pekko-stream"                       % PekkoVersion,
    )
  )
