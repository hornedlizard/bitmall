package com.cafe24.bitmall.vo;

public class CartVo {
	private long memberNo;
	private long productNo;
	private int amount;
	private int totalPrice;
	private long productOptionNo;
	
	public long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(long memberNo) {
		this.memberNo = memberNo;
	}
	public long getProductNo() {
		return productNo;
	}
	public void setProductNo(long productNo) {
		this.productNo = productNo;
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
		return "CartVo [memberNo=" + memberNo + ", productNo=" + productNo
				+ ", amount=" + amount + ", totalPrice=" + totalPrice
				+ ", productOptionNo=" + productOptionNo + "]";
	}
	
}
