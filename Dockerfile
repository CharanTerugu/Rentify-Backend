
FROM openjdk:17
LABEL maintainer="charan"
ADD target/rentify-prjct.jar rentify-prjct
ENV MYSQL_DATABASE=rentify
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root
ENV MYSQL_URL=jdbc:mysql://mysql-hostname:3306/rentify
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/rentify-prjct"]
