import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
  dependencies {
    classpath("gradle.plugin.com.ewerk.gradle.plugins:querydsl-plugin:1.0.10")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.21")
    classpath("org.jetbrains.kotlin:kotlin-allopen:1.8.21")
    classpath("org.jetbrains.kotlin:kotlin-noarg:1.8.21")
  }
}

plugins {
  id("org.springframework.boot") version "3.1.0"
  id("io.spring.dependency-management") version "1.1.0"
  id("org.graalvm.buildtools.native") version "0.9.20"
  kotlin("jvm") version "1.8.21"
  kotlin("plugin.spring") version "1.8.21"
  kotlin("plugin.jpa") version "1.8.21"
  kotlin("kapt") version "1.8.21"
  idea
}

allOpen {
  annotation("jakarta.persistence.Entity")
  annotation("jakarta.persistence.MappedSuperclass")
  annotation("jakarta.persistence.Embeddable")
}

group = "com.blueone"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
  mavenCentral()
}

configurations {
  compileOnly {

  }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework.security:spring-security-test")
  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

  /** QueryDSL & Spring Data JPA **/
  implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.0")
  implementation("com.vladmihalcea:hibernate-types-60:2.20.0")
  implementation("com.infobip:infobip-spring-data-jpa-querydsl-boot-starter:8.0.0")
  kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")

  /** Database **/
  testImplementation("com.h2database:h2:2.1.214")
  implementation("org.mariadb.jdbc:mariadb-java-client:3.1.4")

}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "17"
  }
}

tasks.withType<Test> {
  File(".local.env").forEachLine { line ->
    if (line.isNotEmpty()) {
      val (key, value) = line.split("=")
      environment(key, value)
    }
  }
  useJUnitPlatform()
}

idea {
  module {
    val kaptMain = file("build/generated/source/kapt/main")
    sourceDirs.add(kaptMain)
    generatedSourceDirs.add(kaptMain)
  }
}
