name := "akka-java-seed"

version := "1.0"

scalaVersion := "2.11.7"
val springVersion = "4.2.6.RELEASE"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.11",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.11" % "test",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "com.google.inject" % "guice" % "4.1.0",
  "redis.clients" % "jedis" % "2.8.1",
  "org.apache.commons" % "commons-pool2" % "2.0",
  "com.google.guava" % "guava" % "18.0",
  "org.apache.httpcomponents" % "httpclient" % "4.3.6",
  "org.hibernate" % "hibernate-validator" % "5.1.3.Final",
  "org.javassist" % "javassist" % "3.18.1-GA",
  "org.slf4j" % "slf4j-api" % "1.7.7",
  "org.springframework" % "spring-test" % springVersion,
  "org.springframework" % "spring-tx" % springVersion,
//  "org.springframework" % "spring-jdbc" % springVersion,
  "org.springframework" % "spring-context" % springVersion,
  "org.springframework" % "spring-expression" % springVersion,
  "org.springframework" % "spring-aop" % springVersion,
  "org.springframework" % "spring-beans" % springVersion,
  "org.springframework" % "spring-core" % springVersion,
  "org.springframework.data" % "spring-data-redis" % "1.7.2.RELEASE"

)

unmanagedClasspath in Runtime += baseDirectory.value.getParentFile.getParentFile  / "conf"
  
