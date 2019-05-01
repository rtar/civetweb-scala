# civetweb-scala

CivetWeb bindings for Scala


**WARNING: This is a very early experimental effort. The things may not work as expected or not work at all.**

## How to run

* Run `sbt run` or `sbt compile`.
* Enjoy the HTTP server at `http://localhost:8080/health`.

See `Main.scala` as an example on how to use the bindings.

## Random technical details

* Scala Native Bindgen used to generate the low level bindings (https://scala-native.github.io/scala-native-bindgen/)
* Scalaz is used to wrap them in more useful form.
* CivetWeb 1.11 is included and will be statically linked (https://github.com/civetweb/civetweb).

## Features to be considered

* Publish to maven repository / bintray.