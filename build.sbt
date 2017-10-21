name := "resty-project"

version := "0.0.1"
scalaVersion := "2.12.4"
val JettyVersion = "9.4.6.v20170531"

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging"     % "3.7.2",
  "ch.qos.logback"             %  "logback-classic"   % "1.2.3",
  "org.scala-sbt"              %% "io"                % "1.0.0",
  "com.github.takezoe"         %% "resty"             % "0.0.11",
  "org.eclipse.jetty"          %  "jetty-webapp"      % JettyVersion % "container",
  "org.eclipse.jetty"          %  "jetty-plus"        % JettyVersion % "container",
  "org.eclipse.jetty"          %  "jetty-annotations" % JettyVersion % "container",
  "javax.servlet"              %  "javax.servlet-api"  % "4.0.0" % "provided",
  "org.mockito"                %  "mockito-core"       % "2.9.0" % "test",
  "org.specs2"                 %% "specs2-core"       % "3.9.4" % "test"
)

scalacOptions := Seq("-deprecation")
scalacOptions in Test ++= Seq("-Yrangepos")
javaOptions in Jetty ++= Seq(
  "-Xms512m", "-Xmx512m",
  "-Xloggc:logs/gc_%p_%t.log", "-XX:+PrintGCDetails",
  "-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000"
)

artifactName := { (_, module: ModuleID, artifact: Artifact) =>
  artifact.name + "." + artifact.extension
}
enablePlugins(JettyPlugin)
containerPort := 8080


