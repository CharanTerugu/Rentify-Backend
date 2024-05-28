
FROM maven:3-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM eclipse-temurin:17-alpine
COPY --from=build /target/rentify-prjct.jar rentify-prjct.jar
ENTRYPOINT ["java","-Dspring.profiles.active=render","-jar","rentify-prjct.jar"]