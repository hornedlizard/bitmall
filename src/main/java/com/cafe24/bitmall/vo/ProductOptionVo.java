package com.cafe24.bitmall.vo;

public class ProductOptionVo {
	private long no;
	private String name;
	private long productNo;
	private long optionTypeNo;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getProductNo() {
		return productNo;
	}
	public void setProductNo(long productNo) {
		this.productNo = productNo;
	}
	public long getOptionTypeNo() {
		return optionTypeNo;
	}
	public void setOptionTypeNo(long optionTypeNo) {
		this.optionTypeNo = optionTypeNo;
	}
	
	@Override
	public String toString() {
		return "ProductOptionVo [no=" + no + ", name=" + name + ", productNo=" + productNo
				+ ", optionTypeNo=" + optionTypeNo + "]";
	}
}
