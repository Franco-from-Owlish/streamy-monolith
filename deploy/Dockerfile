# syntax=docker/dockerfile:1

################################################################################

FROM eclipse-temurin:21-jdk-jammy AS build

WORKDIR /app

# Copy the gradlew wrapper with executable permissions, gradle filess, and application source.
COPY --chmod=0755 gradlew gradlew
COPY gradle/ gradle/
COPY build.gradle.kts build.gradle.kts
COPY settings.gradle.kts settings.gradle.kts
COPY ./src src/

# Build project
RUN ./gradlew build -x test

# Make life ea
RUN export PROJECT=$(./gradlew properties -q | awk '/^name:/ {print $2}') \
    export VERSION=$(./gradlew properties -q | awk '/^version:/ {print $2}')
RUN export JAR_FILE=${PROJECT}-${VERSION}.jar
RUN mv build/libs/${JAR_FILE} app.jar

################################################################################

FROM eclipse-temurin:21-jre-jammy AS final

# Create a non-privileged user that the app will run under.
# See https://docs.docker.com/go/dockerfile-user-best-practices/
ARG UID=10001
RUN adduser \
    --disabled-password \
    --gecos "" \
    --home "/nonexistent" \
    --shell "/sbin/nologin" \
    --no-create-home \
    --uid "${UID}" \
    appuser
USER appuser

# Copy the executable from the "build" stage.
COPY --from=build /app/app.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
