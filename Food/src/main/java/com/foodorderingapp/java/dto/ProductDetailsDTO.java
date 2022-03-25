package com.foodorderingapp.java.dto;

public class ProductDetailsDTO {
	private String productDescription;
	private String productName;
	
	public ProductDetailsDTO(String productDescription, String productName) {
		this.productDescription = productDescription;
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}
