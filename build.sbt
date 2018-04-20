resolvers in ThisBuild ++= Seq("Apache Development Snapshot Repository" at "https://repository.apache.org/content/repositories/snapshots/",
    Resolver.mavenLocal)

name := "playground"

version := "0.1-SNAPSHOT"

organization := "com.tennik"

scalaVersion in ThisBuild := "2.12.3"


libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.8.7" % "test"
)

// Read here for optional dependencies:
// https://etorreborre.github.io/specs2/guide/SPECS2-3.8.7/org.specs2.guide.Installation.html#other-dependencies

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)
