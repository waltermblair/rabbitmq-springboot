## How-To
1. `docker run -d --hostname my-rabbit --name some-rabbit -p 8080:15672 -p 5672:5672 rabbitmq:3-management`
2. `mvn clean package && java -jar target/rabbitmq-1.0-SNAPSHOT.jar`
3. `curl -X POST -H "Content-Type: application/json" -d '{"content":"achieved"}' localhost:3000/logs`

## Done
1. Java version

## To-Do
1. Logging
2. Test Implementation
  1. e2e testing
  1. mock rabbit
  1. spy sendToRabbit
  1. code coverage
3. Docker - production
4. Docker - testing w/ Docker-compose
5. Retrieving RabbitMQ reply
6. Refactor tests
7. Final Documentation