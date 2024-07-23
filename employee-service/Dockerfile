FROM amazoncorretto:21
EXPOSE 8084
ADD target/employee-module.jar employee-module.jar
ENTRYPOINT ["java", "-jar", "/employee-module.jar"]