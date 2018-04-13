package com.cafe24.bitmall.vo;

public class BoardVo {
	private long no;
	private String title;
	private String content;
	private String regdate;
	private int hits;
	private int groupNo;
	private int orderNo;
	private int depth;
	private boolean isDelete;
	private long boardKindNo;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public long getBoardKindNo() {
		return boardKindNo;
	}
	public void setBoardKindNo(long boardKindNo) {
		this.boardKindNo = boardKindNo;
	}
	
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", hits="
				+ hits + ", groupNo=" + groupNo + ", orderNo=" + orderNo + ", depth=" + depth + ", isDelete=" + isDelete
				+ ", boardKindNo=" + boardKindNo + "]";
	}
}
