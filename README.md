# sbt-bloop-tmpfs

![v0.1](https://img.shields.io/badge/Maven-v0.1-green)

A plugin to instruct Bloop to compile files on Tmpfs to spare some SSD cycles.

## Usage

1. Add the following to your `project/plugins.sbt` or globally at `~/.sbt/**/plugins/*.sbt`
   ```
   addSbtPlugin("com.github.arbitrary-dev" % "sbt-bloop-tmpfs" % "0.1")
   ```
2. Observe how files are compiled to `$TMPDIR/.bloop/`

## Local testing

Try one of these or both:

```shell
sbt publishLocal
# sbt publishM2
```

## See

- Link to the original issue: https://github.com/scalacenter/bloop/issues/1031

## TODO

- Remove unnecessary [artifacts](https://www.scala-sbt.org/1.x/docs/Artifacts.html)
- Publish to [Maven Central](https://github.com/xerial/sbt-sonatype)
