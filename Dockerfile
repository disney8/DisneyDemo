FROM adoptopenjdk/openjdk11:jdk-11.0.7_10-alpine-slim

# Optional values
ENV APP_NAME="demo"
ENV BUILD_DIR="target"

# Set environments variables
ENV APP_DIR="/opt/app"
ENV JAR_FILE="${BUILD_DIR}/disney-demo-0.0.1-SNAPSHOT.jar"
ENV TZ=America/Havana

RUN apk add --update tzdata

COPY ./target/*.jar app.jar
COPY Script.sql /
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]