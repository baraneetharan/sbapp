
#
# Build stage
#
FROM eclipse-temurin:25-jdk AS build

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean install -DskipTests

#
# Package stage
#
FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY --from=build /app/target/sbapp-0.0.1-SNAPSHOT.jar demo.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","demo.jar"]
