FROM amazoncorretto:11-alpine-jdk
MAINTAINER dc
COPY target/handcalculator-0.0.1-SNAPSHOT.war handcalculator-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/handcalculator-0.0.1-SNAPSHOT.war"]
