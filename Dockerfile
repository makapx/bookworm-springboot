FROM maven:3.8.3-openjdk-17

WORKDIR /app
COPY pom.xml mvnw.cmd mvnw ./

RUN mvn dependency:go-offline

COPY src ./src

RUN mv src/main/resources/example.application.properties src/main/resources/application.properties && \
    sed src/main/resources/application.properties -i -e 's/localhost/database/g'

ENTRYPOINT [ "mvn", "spring-boot:run" ]
