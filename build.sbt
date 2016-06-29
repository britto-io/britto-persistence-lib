name := "akka-java-seed"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.11",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.11" % "test",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "com.google.inject" % "guice" % "4.1.0",
  "redis.clients" % "jedis" % "2.8.1"
)

unmanagedClasspath in Runtime += baseDirectory.value.getParentFile.getParentFile  / "conf"
  
