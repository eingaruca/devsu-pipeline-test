FROM openjdk:17-jdk-alpine

COPY target/*.jar /app/appsb.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "appsb.jar"]
