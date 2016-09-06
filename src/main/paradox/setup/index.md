# Setup

This is what you will be doing, in a nutshell:

* installation of SBT
* installation of LLVM and Clang
* installation of libgc-dev
* run the demo application and see the output generated

#### Installing SBT

Please refer to [this link](http://www.scala-sbt.org/release/docs/Setup.html) for instructions for your Os.

#### Installing LLVM and CLang

**NOTE:** If you already have LLVM >= 3.7 and Clang >= 3.7 installed in your system, you probably can skip to the next section.

Ubuntu
: ```bash
$ sudo apt-get install llvm-3.8
```

OsX
: ```bash
$ brew install homebrew/versions/llvm38
```

FreeBSD
: ```bash
$ pkg install llvm38
```

old Debian/Ubuntu
: ```bash
#please choose your system version instead of 'precise'
$ sudo echo 'deb http://llvm.org/apt/precise/ llvm-toolchain-precise-3.7 main' >> /etc/apt/sources.list
$ sudo sh -c "echo 'deb http://llvm.org/apt/precise/ llvm-toolchain-precise main' >> /etc/apt/sources.list"
$ wget -O - http://llvm.org/apt/llvm-snapshot.gpg.key | sudo apt-key add -
$ sudo add-apt-repository --yes ppa:ubuntu-toolchain-r/test
$ sudo apt-get -qq update
$ sudo apt-get install -y libgc-dev clang++-3.7 llvm-3.7 llvm-3.7-dev llvm-3.7-runtime llvm-3.7-tool
```

#### Installing Boehm GC

You will need to install the default Boehm-GC:

Ubuntu
: ```bash
$ sudo apt-get install libgc-dev
```

OsX
: ```bash
$ brew install bdw-gc
```

FreeBSD
: ```bash
$ pkg install boehm-gc
```

old Debian/Ubuntu
: ```bash
$ git clone git://github.com/ivmai/bdwgc.git
$ cd bdwgc
$ git clone git://github.com/ivmai/libatomic_ops.git
$ autoreconf -vif
$ automake --add-missing
$ ./configure
$ make
$ make check
$ sudo make install
```


#### Run the demo application

Clone or download [scala-native-example](https://github.com/scala-native/scala-native-example)

Run the example application
```bash
  $ cd scala-native-example
  $ sbt run
```

You can now check with your preferred image editor the generated output ```image0.ppm```

## Troubleshooting

Some problems observed and well known solutions:

* In case the build fails, and you are using ``sbt-coursier`` plugin, try to remove its cache at ``$HOME/.coursier`` or try to remove the plugin from the SBT configuration.


## For advanced users only

If your application needs features only available in most recent Scala Native sources, not yet
available in public Maven repositories, you will probably find the instructions below useful.

#### Building and installing Scala Native

Downloading...
```bash
  $ mkdir -p $HOME/workspace
  $ cd $HOME/workspace
  $ git clone https://github.com/scala-native/scala-native.git
  $ cd $HOME/workspace/scala-native
```

Make sure you disable generation of documentation in ``build.sbt``:
```scala
lazy val baseSettings = Seq(
  organization := "org.scala-native",
  version      := nativeVersion,
  sources in doc in Compile := List(), // doc generation currently broken
  scalafmtConfig := Some(file(".scalafmt"))
)
```

Clean everything involving scala-native under your Ivy repository. Then proceed with the build:
```bash
  $ find $HOME/.ivy2 -type d -name '*scala-native*' | xargs rm -r -f
  $ sbt 'cleanCache' 'cleanLocal' 'nscplugin/publishLocal' 'nativelib/publishLocal' 'publishLocal'
```

<a href="https://github.com/scala-native/scala-native"><img style="position: absolute; top: 0; right: 0; border: 0;" src="https://camo.githubusercontent.com/a6677b08c955af8400f44c6298f40e7d19cc5b2d/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f72696768745f677261795f3664366436642e706e67" alt="Fork me on GitHub" data-canonical-src="https://s3.amazonaws.com/github/ribbons/forkme_right_gray_6d6d6d.png"></a>
