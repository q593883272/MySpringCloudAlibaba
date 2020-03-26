FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/provider-resource-1.0.jar /app.jar
ENV JAVA_OPTS=""
CMD ["java","-jar","/app.jar"]