FROM alpine/java:21-jdk
RUN addgroup -S sas && adduser -S sas -G sas
USER sas:sas
ARG JAR_FILE=application/target/application-*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]