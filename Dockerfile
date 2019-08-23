FROM java:8
MAINTAINER Titarenko
COPY build/libs/nso-rest-service-0.0.1-SNAPSHOT.jar /home/nso-rest-service-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/home/nso-rest-service-0.0.1-SNAPSHOT.jar"]
