package bloop.integrations.sbt

import sbt._
import Keys._
import bloop.integrations.sbt.BloopKeys._

object BloopTmpfsPlugin extends AutoPlugin {

  override def requires = BloopPlugin
  override def trigger = allRequirements

  private val tmpDir = sys.env.get("TMPDIR").getOrElse("/tmp")

  override lazy val projectSettings = Seq(
    Compile / bloopClassDirectory := file(s"$tmpDir/.bloop/${ normalizedName.value }"),
    Compile / bloopTargetDir := file(s"$tmpDir/.bloop/${ normalizedName.value }"),
    Compile / bloopAnalysisOut := Some(file(s"$tmpDir/.bloop/${ normalizedName.value }"))
  )
}
