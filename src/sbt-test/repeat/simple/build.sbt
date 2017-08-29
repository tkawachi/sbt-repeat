import sbt.complete.DefaultParsers._
import sbt.IO

lazy val root = project.in(file("."))
  .settings(
    TaskKey[Unit]("write") := {
      IO.append(target.value / "count.txt", "a")
    },
    InputKey[Unit]("check") := {
      val n = (Space ~> NatBasic).parsed
      val len = IO.read(target.value / "count.txt").length
      if (n != len) {
        sys.error(s"len $len != $n")
      }
      ()
    }
)
