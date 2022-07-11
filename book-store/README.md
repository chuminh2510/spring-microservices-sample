* To build project:

```bash
mvn clean install -DskipTests
```

* To create docker image:

```bash
#./book-store -> to build all of Docker images OR `cd` to specify project to build
./mvnw spring-boot:build-image -pl \!core -Dmaven.test.skip=true
## Ignore Docker image for core module because of base source code
# After finished:
docker image ls
## Output example:
### book-service   0.0.1-SNAPSHOT ...
```

* Common

```shell
# ./00-common
kubectl apply -f 00-namespace.yml
kubectl apply -f 01-persistent-volumn.yml
kubectl apply -f 02-postgres-secret.yml
# Check created namespace
kubectl get namespace
# Check Persistent volume
kubectl get pv -n book-store
# Check secrets
kubectl describe secrets/postgres-secret -n book-store
```

* Deploy Eureka server

```shell
# ./01-eureka-server
kubectl apply -f 01-eureka-server-deployment.yml
kubectl apply -f 02-eureka-server-service.yml
# To check service:
kubectl get service -n book-store
```

* Deploy Book service

```shell
# ./02-book-service
kubectl apply -f 01-persistent-volumn-claim.yml

# Check PVC
kubectl get pvc -n book-store

```
