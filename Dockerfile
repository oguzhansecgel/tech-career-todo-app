FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk
COPY --from=build /app/target/to-do-app-0.0.1-SNAPSHOT.jar /app/to-do-app.jar
EXPOSE 8079
CMD ["java", "-jar", "/app/to-do-app.jar"]