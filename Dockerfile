FROM openjdk:8
EXPOSE 8080
ADD target/spr-entity.jar spr-entity.jar
ENTRYPOINT ["java" , "-jar" , "spr-entity.jar"]
