ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.1.3"
name := "zio-siha"

libraryDependencies ++= Seq(
  "dev.zio"     %% "zio"            % "2.0.0",
  "dev.zio"     %% "zio-json"       % "0.3.0-RC8",
  "io.d11"      %% "zhttp"          % "2.0.0-RC10",
  "io.getquill" %% "quill-zio"      % "4.2.0",
  "io.getquill" %% "quill-jdbc-zio" % "4.2.0",
  "com.h2database" % "h2"           % "2.1.212"
)

