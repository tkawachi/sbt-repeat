ThisBuild / scalafmtOnCompile := true

ThisBuild / versionScheme := Some("early-semver")

val commonSettings = Seq(
  organization := "com.github.tkawachi",
  licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/tkawachi/sbt-repeat/"),
      "scm:git:github.com:tkawachi/sbt-repeat.git"
    )
  ),
  scalaVersion := "2.12.13",
  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding",
    "UTF-8",
    "-feature",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint"
  )
)

lazy val root = project
  .in(file("."))
  .enablePlugins(SbtPlugin)
  .settings(commonSettings: _*)
  .settings(
    name := "sbt-repeat",
    scriptedLaunchOpts := {
      scriptedLaunchOpts.value ++
        Seq(
          "-Xmx1024M",
          "-XX:MaxPermSize=256M",
          "-Dplugin.version=" + version.value
        )
    },
    scriptedBufferLog := false
  )
