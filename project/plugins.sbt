// #sn_config
resolvers += Resolver.sonatypeRepo("snapshots")

addSbtPlugin("org.scala-native" % "sbtplugin"  % "0.1-SNAPSHOT")
// #sn_config
addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.2.0")
