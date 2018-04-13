package com.cafe24.bitmall.vo;

public class EventVo {
	private long no;
	private String event;
	private float dc;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public float getDc() {
		return dc;
	}
	public void setDc(float dc) {
		this.dc = dc;
	}
	
	@Override
	public String toString() {
		return "EventVo [no=" + no + ", event=" + event + ", dc=" + dc + "]";
	}
	
}
