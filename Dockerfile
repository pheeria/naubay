FROM clojure:openjdk-11-lein-slim-buster AS build-jar

ARG DB_URL
ENV DB_URL=$DB_URL

COPY project.clj /usr/builder/
COPY src /usr/builder/src/

WORKDIR /usr/builder
RUN lein uberjar

FROM openjdk:11-jre-slim-buster
COPY --from=build-jar /usr/builder/target/uberjar/naubay-0.1.0-SNAPSHOT-standalone.jar /usr/app/

WORKDIR /usr/app
CMD ["java", "-jar", "naubay-0.1.0-SNAPSHOT-standalone.jar"]
