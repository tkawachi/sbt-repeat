val commonSettings = Seq(
  organization := "com.github.tkawachi",
  licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
  scmInfo := Some(ScmInfo(
    url("https://github.com/tkawachi/sbt-repeat/"),
    "scm:git:github.com:tkawachi/sbt-repeat.git"
  )),

  scalaVersion := "2.10.4",
  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint"
  ),

  doctestTestFramework := DoctestTestFramework.ScalaTest
) ++ scalariformSettings ++ doctestSettings

lazy val root = project.in(file("."))
  .settings(commonSettings :_*)
  .settings(
    name := "sbt-repeat",
    sbtPlugin := true
  )
