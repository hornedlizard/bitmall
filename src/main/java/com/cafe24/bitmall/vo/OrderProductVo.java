package com.cafe24.bitmall.vo;

public class OrderProductVo {
	private long no;
	private long orderNo;
	private long productNo;
	private int price;
	private int amount;
	private int totalPrice;
	private long productOptionNo;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}
	public long getProductNo() {
		return productNo;
	}
	public void setProductNo(long productNo) {
		this.productNo = productNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getProductOptionNo() {
		return productOptionNo;
	}
	public void setProductOptionNo(long productOptionNo) {
		this.productOptionNo = productOptionNo;
	}
	
	@Override
	public String toString() {
		return "OrderProductVo [no=" + no + ", orderNo=" + orderNo + ", productNo=" + productNo 
				+ ", price=" + price + ", amount=" + amount + ", totalPrice=" + totalPrice 
				+ ", productOptionNo=" + productOptionNo + "]";
	}
	
}
