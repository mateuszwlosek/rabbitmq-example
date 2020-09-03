package com.githhub.mateuszwlosek.rabbitmq.product;

import com.githhub.mateuszwlosek.rabbitmq.product.Product.PurchaseInfo;
import com.githhub.mateuszwlosek.rabbitmq.properties.RabbitExchangesProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

	private final RabbitExchangesProperties exchangesProperties;
	private final RabbitTemplate rabbitTemplate;

	@PostMapping("/buy")
	public void buyProduct(@RequestParam final String deliveryAddress,
						   @RequestParam final String username,
						   @RequestParam final String productName,
						   @RequestParam final int price,
						   @RequestParam final int warrantyPeriod) {
		log.info("Received request to buy product: {}", productName);

		final PurchaseInfo purchaseInfo = PurchaseInfo.builder()
			.deliveryAddress(deliveryAddress)
			.username(username)
			.build();

		final Product product = Product.builder()
			.name(productName)
			.price(price)
			.warrantyPeriodYears(warrantyPeriod)
			.purchaseInfo(purchaseInfo)
			.build();

		rabbitTemplate.convertAndSend(exchangesProperties.getProductPurchase().getName(), "", product);
	}
}
