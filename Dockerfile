FROM java:8
EXPOSE 8081

VOLUME /tmp
WORKDIR /app
ADD imerp.jar app.jar
RUN bash -c 'touch /app/app.jar'
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app/app.jar"]