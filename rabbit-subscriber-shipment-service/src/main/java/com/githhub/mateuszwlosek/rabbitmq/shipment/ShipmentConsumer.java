package com.githhub.mateuszwlosek.rabbitmq.shipment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ShipmentConsumer {

	@RabbitListener(queues = "${application.listener.queues.shipProduct.name}")
	public void shipProductEventConsume(final Product product) {
		log.info("I received event about request to ship product: {}", product);
	}
}
