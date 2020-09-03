# RabbitMQ - Example

Example of [RabbitMQ](https://www.rabbitmq.com/) usage with publisher and subscriber on queues and exchanges.

Services were developer in [Spring Boot](https://projects.spring.io/spring-boot/).  
Used [Docker](https://www.docker.com/) to containerize environment.  

## RabbitMQ
![RabbitMQ Diagram](https://user-images.githubusercontent.com/15820051/82729811-249acc80-9cc0-11ea-94b4-e24fd9d8387c.png)

## How to run the environment?

### Before you start
* Make sure you have `Docker` and `docker-compose` installed.

[Docker CE INSTALLATION](https://docs.docker.com/install/linux/docker-ce/ubuntu/)  
[Docker Compose INSTALLATION](https://docs.docker.com/compose/install/#prerequisites)

### Start the environment
1. Build services:
    `docker-compose build`
2. Run services:
    `docker-compose up`
3. Run multiple instances of one of the subscriber services:
    `docker-compose scale rabbit-subscriber-invoice-service=2`

### Important endpoints:

* http://localhost:15672/ - RabbitMQ Management Interface (credentials: user/user)

### Example requests:

* curl -X POST "http://localhost:8080/user?username=test-username" - Invoke purchase service endpoint, so it would send a message to *createUser* queue
* curl -X POST "http://localhost:8080/product/buy?deliveryAddress=Los%20Angeles&username=test-username&productName=test-product&price=123&warrantyPeriod=2" - Invoke purchase service endpoint, so it would send a message to *purchaseProduct* exchange


