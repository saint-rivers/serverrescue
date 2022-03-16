FROM amazoncorretto:11-alpine-jdk
COPY target/serverRescue.jar /opt
ENTRYPOINT ["java", "-jar", "/opt/serverRescue.jar"]