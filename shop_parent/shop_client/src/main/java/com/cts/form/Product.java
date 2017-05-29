package com.cts.form;

public class Product {
	private Integer productId;
	private String productName;
	private Integer price;

	public Product() {
		super();
	}

	public Product(Integer productId, String productName, Integer price) {

		this.productId = productId;
		this.productName = productName;
		this.price = price;
		/*
		 * this.manufacturingDate = manufacturingDate; this.expiryDate =
		 * expiryDate;
		 */
	}

	/*
	 * public Product() { super(); }
	 */

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	/*
	 * public Date getManufacturingDate() { return manufacturingDate; }
	 * 
	 * public void setManufacturingDate(Date manufacturingDate) {
	 * this.manufacturingDate = manufacturingDate; }
	 * 
	 * public Date getExpiryDate() { return expiryDate; }
	 * 
	 * public void setExpiryDate(Date expiryDate) { this.expiryDate =
	 * expiryDate; }
	 */
}
