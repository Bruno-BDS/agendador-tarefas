FROM gradle:8-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

FROM azul/zulu-openjdk:17

WORKDIR /app

COPY --from=build /app/build/libs/*.jar  /app/agendador-tarefas.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/agendador-tarefas.jar"]