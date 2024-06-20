lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  //.enablePlugins(PlayNettyServer).disablePlugins(PlayPekkoHttpServer) // uncomment to use the Netty backend
  .settings(
    name := "play-java-websocket-example",
    version := "1.0-SNAPSHOT",
    crossScalaVersions := Seq("2.13.14", "3.3.3"),
    scalaVersion := crossScalaVersions.value.head,
    libraryDependencies ++= Seq(
      guice,
      ws,
      "org.webjars" %% "webjars-play" % "3.0.1",
      "org.webjars" % "flot" % "0.8.3-1",
      "org.webjars" % "bootstrap" % "3.3.7-1",
      "org.assertj" % "assertj-core" % "3.25.3" % Test,
      "org.awaitility" % "awaitility" % "4.2.1" % Test,
    ),
    TwirlKeys.templateImports ++= Seq(
      "views.html.helper.CSPNonce"
    ),
    LessKeys.compress := true,
    // https://github.com/sbt/junit-interface
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-v"),
    javacOptions ++= Seq(
      "-Xlint:unchecked",
      "-Xlint:deprecation",
      "-Werror"
    )
  )
