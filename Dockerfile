FROM clojure:openjdk-11-lein-slim-buster AS build-jar
WORKDIR /usr/src
COPY . .

RUN lein uberjar

FROM openjdk:11-jre-slim-buster
WORKDIR /usr/app

COPY --from=build-jar /usr/src/target/uberjar/naubay-0.1.0-SNAPSHOT-standalone.jar .
CMD ["java", "-jar", "naubay-0.1.0-SNAPSHOT-standalone.jar"]
