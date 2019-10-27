package bloop.integrations.sbt

import sbt._
import Keys._
import bloop.integrations.sbt.BloopKeys._

object BloopTmpfsPlugin extends AutoPlugin {

  override def requires = BloopPlugin
  override def trigger = allRequirements

  override lazy val projectSettings = Seq(
    Compile / bloopClassDirectory := file(s"/tmp/bloop-project/${ normalizedName.value }"),
    Compile / bloopTargetDir := file(s"/tmp/bloop-project/${ normalizedName.value }"),
    Compile / bloopAnalysisOut := Some(file(s"/tmp/bloop-project/${ normalizedName.value }"))
  )
}
