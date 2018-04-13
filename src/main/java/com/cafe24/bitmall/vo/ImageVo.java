package com.cafe24.bitmall.vo;

public class ImageVo {
	private long no;
	private String image;
	private long productNo;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getProductNo() {
		return productNo;
	}
	public void setProductNo(long productNo) {
		this.productNo = productNo;
	}
	@Override
	public String toString() {
		return "ImageVo [no=" + no + ", image=" + image + ", productNo=" + productNo + "]";
	}
	
}
