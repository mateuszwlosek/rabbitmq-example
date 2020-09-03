package com.githhub.mateuszwlosek.rabbitmq.user;

import com.githhub.mateuszwlosek.rabbitmq.properties.RabbitQueuesProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

	private final RabbitQueuesProperties queuesProperties;
	private final RabbitTemplate rabbitTemplate;

	@PostMapping
	public void createUser(@RequestParam final String username) {
		log.info("Received request to create user with username: {}", username);

		final User user = new User(username);
		rabbitTemplate.convertAndSend(queuesProperties.getCreateUser().getName(), user);
	}
}
