package com.githhub.mateuszwlosek.rabbitmq.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "application.listener.queues")
public class RabbitQueuesProperties {

	private QueueConfiguration createUser;

	@Data
	public static class QueueConfiguration {
		private String name;
	}
}

