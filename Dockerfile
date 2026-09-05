FROM gradle:jdk26-alpine AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

FROM azul/zulu-openjdk:26-latest

WORKDIR /app

COPY --from=build /app/build/libs/*.jar  /app/agendador-tarefas.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/agendador-tarefas.jar"]