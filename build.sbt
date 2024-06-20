val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "app",
    version := "1.0",

    scalaVersion := scala3Version,
    javacOptions ++= Seq("-source", "17"),

    /* Scalatest */
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.18",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % "test",

    /* Scala Swing */
    libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0",

    /* ScalaFX */
    libraryDependencies += "org.scalafx" %% "scalafx" % "22.0.0-R33",
    libraryDependencies ++= {
      // Determine OS version of JavaFX binaries
      lazy val osName = System.getProperty("os.name") match {
        case n if n.startsWith("Linux") => "linux"
        case n if n.startsWith("Mac") => "mac"
        case n if n.startsWith("Windows") => "win"
        case _ => throw new Exception("Unknown platform!")
      }
      Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
        .map(m => "org.openjfx" % s"javafx-$m" % "16" classifier osName)
    },
    fork := true,

    /* Scala formatter */
    libraryDependencies += "org.scalameta" % "sbt-scalafmt_2.12_1.0" % "2.5.2",

    /* Wartremover */
    wartremoverErrors ++= Warts.unsafe,
    wartremoverWarnings ++= Warts.unsafe
  )
