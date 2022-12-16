package com.model;

import java.util.Date;

public class Orders {
	private int id;
	private User custId;
	private int totalAmount;
	private Date orderDate;
	public Orders() {
		super();
	}
	public Orders(int id, User custId, int totalAmount, Date orderDate) {
		super();
		this.id = id;
		this.custId = custId;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getCustId() {
		return custId;
	}
	public void setCustId(User custId) {
		this.custId = custId;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", custId=" + custId + ", totalAmount=" + totalAmount + ", orderDate=" + orderDate
				+ "]";
	}
	

}
