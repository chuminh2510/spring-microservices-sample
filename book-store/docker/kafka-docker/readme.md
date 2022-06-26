* Reference to: https://developer.confluent.io/quickstart/kafka-docker/
* To start Kafka, use below command:

```shell
docker-compose up -d
```

* Test Kafka run successful

```shell
# New terminal
docker exec --interactive --tty broker kafka-console-consumer --bootstrap-server broker:9092 --topic quickstart --from-beginning
# New terminal
docker exec --interactive --tty broker kafka-console-producer --bootstrap-server broker:9092  --topic quickstart
## Write something
```

* To stop Kafka:

```shell
docker-compose down
```
