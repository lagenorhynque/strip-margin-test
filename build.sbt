lazy val root = (project in file("."))
  .settings(
    name := "strip-margin-test",
    version := "0.1.0",
    scalaVersion := "2.12.1",
    scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint"),
    libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.1" % "test"
  )
