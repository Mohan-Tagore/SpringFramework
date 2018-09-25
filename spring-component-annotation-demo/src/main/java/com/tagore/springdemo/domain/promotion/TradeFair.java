package com.tagore.springdemo.domain.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tagore.springdemo.domain.product.ConsumerProduct;
import com.tagore.springdemo.domain.product.IndustrialProduct;

@Component("myFair")
public class TradeFair {

	private IndustrialProduct industrialProduct;
	private ConsumerProduct consumerProduct;

/*	public TradeFair() {
	}
*/
	@Autowired
	public TradeFair(IndustrialProduct industrialProduct, ConsumerProduct consumerProduct) {
		super();
		this.industrialProduct = industrialProduct;
		this.consumerProduct = consumerProduct;
	}

	public int declareIndustrialProduct(IndustrialProduct industrialProduct) {
		return industrialProduct.calculatePrice();
	}

	public int declareConsumerProduct(ConsumerProduct consumerProduct) {
		return consumerProduct.calculatePrice();
	}

	public String specialPromotionalPricing() {
		String priceInfo = "Industrial Product priced at $" + declareIndustrialProduct(industrialProduct)
				+ " and Consumer Product priced at $" + declareConsumerProduct(consumerProduct);
		return priceInfo;
	}

	/*@Autowired
	public void setIndustrialProduct(IndustrialProduct industrialProduct) {
		this.industrialProduct = industrialProduct;
	}

	@Autowired
	public void setConsumerProduct(ConsumerProduct consumerProduct) {
		this.consumerProduct = consumerProduct;
	}*/
}
