name := "scala-djug-20190508"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.8"

scalacOptions ++=
  Seq("-Ypartial-unification", "-Xfatal-warnings", "-unchecked", "-deprecation", "-feature")

libraryDependencies ++=
  Seq("org.scalatest" %% "scalatest" % "3.0.6" % Test,
    "org.typelevel" %% "cats-core" % "1.0.0")
