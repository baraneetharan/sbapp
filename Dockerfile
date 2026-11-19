#
# Build stage
#
FROM eclipse-temurin:25-jdk AS build
COPY . .
RUN mvn clean install

#
# Package stage
#
FROM eclipse-temurin:25-jdk
COPY --from=build /target/sbapp-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]