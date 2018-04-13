package com.cafe24.bitmall.vo;

public class OptionTypeVo {
	private long no;
	private String type;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "OptionTypeVo [no=" + no + ", type=" + type + "]";
	}
	
}
