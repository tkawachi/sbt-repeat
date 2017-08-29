package com.github.tkawachi.sbt.repeat

import sbt._, Keys._
import sbt.complete.DefaultParsers._
import sbt.complete.Parser

object RepeatPlugin extends AutoPlugin {

  override val trigger: PluginTrigger = allRequirements

  private val argParser
    : Parser[(Int, String)] = Space ~> NatBasic ~ (Space ~> any.+.string)

  private lazy val repeat: Command = Command("repeat")(_ => argParser) {
    case (st, (n, rest)) =>
      st.log.info(s"Repeating `$rest` $n times")
      List.tabulate(n)(_ => rest) ::: st
  }

  override lazy val globalSettings = Seq(
    commands += repeat
  )
}
