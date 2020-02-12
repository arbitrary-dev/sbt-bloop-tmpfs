package bloop.integrations.sbt

import sbt._
import Keys._
import bloop.integrations.sbt.BloopKeys._

object BloopTmpfsPlugin extends AutoPlugin {

  override def requires = BloopPlugin
  override def trigger = allRequirements

  private val tmpDir = sys.env.get("TMPDIR").getOrElse("/tmp")
  private val hash = System.nanoTime().hashCode.toHexString
  private val targetDir = s"$tmpDir/.bloop/$hash"

  println(s"Bloop Tmpfs plugin target directory: $targetDir")

  override lazy val projectSettings = Seq(
    Compile / bloopClassDirectory := file(s"$targetDir/${ normalizedName.value }"),
    Compile / bloopTargetDir := file(s"$targetDir/${ normalizedName.value }"),
    Compile / bloopAnalysisOut := Some(file(s"$targetDir/${ normalizedName.value }"))
  )
}
