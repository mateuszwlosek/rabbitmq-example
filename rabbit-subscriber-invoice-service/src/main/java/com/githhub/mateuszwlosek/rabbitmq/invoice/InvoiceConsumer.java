package com.githhub.mateuszwlosek.rabbitmq.invoice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InvoiceConsumer {

	@RabbitListener(queues = "${application.listener.queues.generateInvoice.name}")
	public void generateInvoiceEventConsume(final Product product) {
		log.info("I received event about request to generate invoice of purchase of product: {}", product);
	}
}
