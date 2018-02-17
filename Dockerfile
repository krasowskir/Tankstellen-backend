FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD target/Tankstellen-backend-0.0.1-SNAPSHOT.jar Tankstellen-backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/Tankstellen-backend.jar"]
