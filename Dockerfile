FROM amazoncorretto:21

COPY target/prova-intermediaria-software-0.0.1-SNAPSHOT.jar /app.jar   (o copy eh de acordo com o artifact id e version inicial do pom.xml) 

ENTRYPOINT ["java", "-jar", "app.jar"]
