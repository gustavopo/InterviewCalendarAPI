# 1 BUILD MAVEN:    mvn spring-boot:build-image
# 2 Build Image:    docker build -t interview:latest .
# 3 Run Container:  docker run -d -p 8080:8080 <image>

FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]



