FROM java:openjdk-8u91-jdk
VOLUME /tmp
ADD /target/discovery-service.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar", "--server.port=8761"]