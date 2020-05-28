name := "redis4cats-sample"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-effect" % "1.2.0",
  "dev.profunktor" %% "redis4cats-effects" % "0.10.0"
)
