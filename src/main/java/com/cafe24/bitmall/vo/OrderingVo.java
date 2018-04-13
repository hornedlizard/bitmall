package com.cafe24.bitmall.vo;

public class OrderingVo {
	private long no;
	private String orderCode;
	private String orderDate;
	private int totalPrice;
	private String state;
	private long memberNo;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(long memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "OrderingVo [no=" + no + ", orderCode=" + orderCode + ", orderDate=" + orderDate 
				+ ", totalPrice=" + totalPrice + ", state=" + state + ", memberNo=" + memberNo 
				+ ", state=" + state + "]";
	}
}
