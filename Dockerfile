FROM gradle:5.5.1-jdk8 as builder

WORKDIR /app

ENV MONGO_HOST=localhost
ENV MONGO_PORT=27017

COPY build.gradle.kts .
COPY settings.gradle.kts .
RUN gradle build || return 0

COPY ./ .
RUN gradle build

FROM openjdk:8-jre-alpine

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]