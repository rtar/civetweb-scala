# civetweb-scala

CivetWeb bindings for Scala

**WARNING: This is a very early experimental effort. The things may not work as expected or not work at all.**

## How to run

* Make and install CivetWeb (https://github.com/civetweb/civetweb).
* Run `sbt run` or `sbt compile`.
* Enjoy.

See `Main.scala` as an example on how to use the bindings.

## Random technical details

* Scala Native Bindgen used to generate the low level bindings (https://scala-native.github.io/scala-native-bindgen/)
* Scalaz is used to wrap them in more useful form.
* CivetWeb dynamic library is expected to be installed (https://github.com/civetweb/civetweb).

## Features to be considered

* Publish to maven repository / bintray.
* Add CivetWeb directly to the repository, so it compiles without any external dependencies.
* Make static binary, if possible.