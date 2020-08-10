import Dependencies._

ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.reshiftsecurity"
ThisBuild / organizationName := "Reshift Security"

lazy val root = (project in file("."))
  .settings(
    name := "SARIF Scala",
    libraryDependencies += scalaTest % Test
  )

