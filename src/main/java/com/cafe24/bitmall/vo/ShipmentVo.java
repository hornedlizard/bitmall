package com.cafe24.bitmall.vo;

public class ShipmentVo {
	private long no;
	private String name;
	private String tel;
	private String phone;
	private String address;
	private String memo;
	
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Override
	public String toString() {
		return "ShipmentVo [no=" + no + ", name=" + name + ", tel=" + tel 
				+ ", phone=" + phone + ", address=" + address + ", memo=" + memo + "]";
	}
}
