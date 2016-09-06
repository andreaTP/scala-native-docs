enablePlugins(ParadoxPlugin)

// #sn_build
enablePlugins(ScalaNativePlugin)

scalaVersion := "2.11.8"
// #sn_build

name := "scala-native-example-docs"

paradoxTheme := Some(builtinParadoxTheme("generic"))

lazy val deploy = taskKey[Unit]("Deploy pages for github docs")

deploy := {
  IO.copyDirectory(
    target.value / "paradox" / "site",
    file("docs/"),
    overwrite = true,
    preserveLastModified = true)
}
