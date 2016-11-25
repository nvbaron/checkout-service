name := "checkout-service"

organization := "uk.shopping.cart"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.4" % "test",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)

retrieveManaged := true
