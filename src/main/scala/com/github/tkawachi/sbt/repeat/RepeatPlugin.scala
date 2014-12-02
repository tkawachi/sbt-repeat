package com.github.tkawachi.sbt.repeat

import sbt._, Keys._
import sbt.complete.DefaultParsers._
import sbt.complete.Parser

object RepeatPlugin extends sbt.Plugin {
  val argParser: Parser[(Int, String)] = Space ~> NatBasic ~ (Space ~> any.+.string)

  lazy val repeat = Command("repeat")(_ => argParser) {
    case (st, (n, rest)) =>
      st.log.info(s"Repeating `$rest` $n times")
      Seq.tabulate(n)(_ => rest) ::: st
  }

  override lazy val globalSettings = Seq(
    commands += repeat
  )
}
