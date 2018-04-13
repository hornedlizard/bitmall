package com.cafe24.bitmall.vo;

public class ProductVo {
	private long no;
	private String code;
	private long categoryNo;
	private String name;
	private int price;
	private String manufact;
	private String origin;
	private String descr;
	private String state;
	private long eventNo;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getManufact() {
		return manufact;
	}
	public void setManufact(String manufact) {
		this.manufact = manufact;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getEventNo() {
		return eventNo;
	}
	public void setEventNo(long eventNo) {
		this.eventNo = eventNo;
	}
	
	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", code=" + code + ", categoryNo=" + categoryNo
				+ ", name=" + name + ", price=" + price + ", manufact=" + manufact 
				+ ", origin=" + origin + ", descr=" + descr + ", state=" + state
				+ ", eventNo=" + eventNo + "]";
	}
	
}
