package com.cafe24.bitmall.vo;

public class BoardKindVo {
	private long no;
	private String boardKind;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getBoardKind() {
		return boardKind;
	}
	public void setBoardKind(String boardKind) {
		this.boardKind = boardKind;
	}
	
	@Override
	public String toString() {
		return "BoardKindVo [no=" + no + ", boardKind=" + boardKind + "]";
	}
}
