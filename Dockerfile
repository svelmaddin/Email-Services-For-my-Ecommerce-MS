FROM openjdk:17-jdk
EXPOSE 9091
ADD target/emailSender-0.0.1-SNAPSHOT.jar emailSender.jar
HEALTHCHECK --interval=30s --timeout=10s --retries=3 \
  CMD curl --fail http://localhost:9092/ || exit 1
ENTRYPOINT ["java" ,"-jar" , "emailSender.jar"]