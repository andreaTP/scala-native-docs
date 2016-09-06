#please choose your system version instead of 'precise'
  $ sudo echo 'deb http://llvm.org/apt/precise/ llvm-toolchain-precise-3.7 main' >> /etc/apt/sources.list
  $ sudo sh -c "echo 'deb http://llvm.org/apt/precise/ llvm-toolchain-precise main' >> /etc/apt/sources.list"
  $ wget -O - http://llvm.org/apt/llvm-snapshot.gpg.key | sudo apt-key add -
  $ sudo add-apt-repository --yes ppa:ubuntu-toolchain-r/test
  $ sudo apt-get -qq update
  $ sudo apt-get install -y libgc-dev clang++-3.7 llvm-3.7 llvm-3.7-dev llvm-3.7-runtime llvm-3.7-tool
