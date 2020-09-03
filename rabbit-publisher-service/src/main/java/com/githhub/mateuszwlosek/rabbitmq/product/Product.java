package com.githhub.mateuszwlosek.rabbitmq.product;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private String name;
	private long price;
	private long warrantyPeriodYears;
	private PurchaseInfo purchaseInfo;

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class PurchaseInfo {

		private String username;
		private String deliveryAddress;
	}
}
