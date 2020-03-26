FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/provider-user-1.0.jar /app.jar
ENV JAVA_OPTS=""
CMD ["java","-jar","/app.jar"]