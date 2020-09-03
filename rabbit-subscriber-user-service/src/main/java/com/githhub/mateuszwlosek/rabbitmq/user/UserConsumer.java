package com.githhub.mateuszwlosek.rabbitmq.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserConsumer {

	@RabbitListener(queues = "${application.listener.queues.createUser.name}")
	public void createUserEventConsumer(final User user) {
		log.info("I received event about request to create user: {}", user);
	}
}
