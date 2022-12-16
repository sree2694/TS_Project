package com.model;

import java.util.Date;

public class OrderDetails {
	private int id;
	private Orders orderId;
	private Product ProductId;
	private int quantity;
	
	public OrderDetails() {
		super();
	}
	
	public OrderDetails(int id, Orders orderId, Product productId, int quantity) {
		super();
		this.id = id;
		this.orderId = orderId;
		ProductId = productId;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Orders getOrderId() {
		return orderId;
	}
	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}
	public Product getProductId() {
		return ProductId;
	}
	public void setProductId(Product productId) {
		ProductId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orderId=" + orderId + ", ProductId=" + ProductId + ", quantity=" + quantity
				+ "]";
	}
	
}
