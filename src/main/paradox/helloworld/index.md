# Hello World

If you have reached this section you probably have a system that is now able to compile and run Scala Native programs.

Start within a new folder,
and create a file ```project/plugins.sbt``` as follows:

@@snip [build.sbt](../../../../project/plugins.sbt) { #sn_config }

define a new ```build.sbt```:

@@snip [build.sbt](../../../../build.sbt) { #sn_build }

and now you can write your first application in ```./src/main/scala/HelloWorld.scala```:

@@snip [HelloWorld.scala](../../scala/HelloWorld.scala)

now simply run ```sbt run``` to get everything compiled and have the expected output!

<a href="https://github.com/scala-native/scala-native"><img style="position: absolute; top: 0; right: 0; border: 0;" src="https://camo.githubusercontent.com/a6677b08c955af8400f44c6298f40e7d19cc5b2d/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f72696768745f677261795f3664366436642e706e67" alt="Fork me on GitHub" data-canonical-src="https://s3.amazonaws.com/github/ribbons/forkme_right_gray_6d6d6d.png"></a>
