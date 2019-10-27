sbtPlugin := true

organization := "com.github.arbitrary-dev"
name := "sbt-bloop-tmpfs"
version := "0.1"

import Defaults._

libraryDependencies += {
  val sbtVersion = Keys.sbtBinaryVersion.in(TaskKey[Unit]("pluginCrossBuild")).value
  val scalaVersion = Keys.scalaBinaryVersion.in(update).value
  val bloopModule = "ch.epfl.scala" % "sbt-bloop" % "1.3.4"
  val bloopPlugin = sbtPluginExtra(bloopModule, sbtVersion, scalaVersion)
  bloopPlugin
}
