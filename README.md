## How-To
1. `docker run -d --hostname my-rabbit --name some-rabbit -p 8080:15672 -p 5672:5672 rabbitmq:3-management`
2. `mvn clean package && java -jar target/rabbitmq-1.0-SNAPSHOT.jar`
3. `curl -X POST -H "Content-Type: application/json" -d '{"content":"achieved"}' localhost:3000/logs`

## Done
1. Java version
1. Logging
1. Test Implementation

## Notes
This came together pretty quickly given that I just learned about Spring Boot last week and have never tried testing on it. Existing tests require RabbitMQ to be running, because I'm not yet sure how to mock RabbitMQ. I would probably try to embrase Docker's ease/speed of use and pursue a docker-compose solution first were I to pursue system tests. 