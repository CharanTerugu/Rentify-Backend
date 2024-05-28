FROM openjdk:20
LABEL maintainer="charan"
ADD target/Rentify-1.jar rentify.jar
ENTRYPOINT ["java","-jar","rentify.jar"]