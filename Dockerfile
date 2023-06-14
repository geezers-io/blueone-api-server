FROM gradle:7.6.1-jdk17-alpine AS builder
RUN mkdir /builder
WORKDIR /builder
COPY settings.gradle.kts .
COPY build.gradle.kts .
COPY src src
RUN gradle bootJar

FROM openjdk:17-alpine
RUN mkdir /opt/app
ENV JAR_NAME=blueone-server-0.0.1-SNAPSHOT.jar
ENV JAR_PATH=/opt/app/$JAR_NAME
COPY --from=builder /builder/build/libs/$JAR_NAME /opt/app/$JAR_NAME
RUN ls -al /opt/app
EXPOSE 8080
ENTRYPOINT java -jar $JAR_PATH
