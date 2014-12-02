# sbt-repeat

Repeat arbitrary command many times.

Add a following line to `~/.sbt/0.13/plugins/repeat.sbt`
(or `project/plugins.sbt`):

    addSbtPlugin("com.github.tkawachi" % "sbt-repeat" % "0.0.1")

It will repeat `run` command 100 times when you execute following command
in the `example` directory:

    $ sbt "repeat 100 run"
