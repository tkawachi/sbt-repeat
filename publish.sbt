import sbtrelease.ReleaseStateTransformations._

releaseCrossBuild := true

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  releaseStepCommandAndRemaining("^ test"),
  releaseStepCommandAndRemaining("^ scripted"),
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommandAndRemaining("^ publishSigned"),
  setNextVersion,
  commitNextVersion,
  releaseStepCommand("sonatypeReleaseAll"),
  pushChanges
)

pomExtra := {
  <url>https://github.com/tkawachi/sbt-repeat/</url>
  <developers>
    <developer>
      <id>kawachi</id>
      <name>Takashi Kawachi</name>
      <url>https://github.com/tkawachi</url>
    </developer>
  </developers>
}
