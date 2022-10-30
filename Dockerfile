#FROM openjdk:11
FROM maven
RUN mkdir app
WORKDIR app
COPY . .
RUN mvn clean install -DskipTests
EXPOSE 8070
ENTRYPOINT java -jar -Xmx3g -Xms1g -Dspring.profiles.active=dev -Djdk.tls.client.protocols=TLSv1.2 target/gplacesProject-0.0.1-SNAPSHOT.jar