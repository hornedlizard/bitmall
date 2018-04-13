package com.cafe24.bitmall.vo;

public class ReceiptVo {
	private long no;
	private String paymentOption;
	private String cardApprovalCode;
	private int installment;
	private String account;
	private String name;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	public String getCardApprovalCode() {
		return cardApprovalCode;
	}
	public void setCardApprovalCode(String cardApprovalCode) {
		this.cardApprovalCode = cardApprovalCode;
	}
	public int getInstallment() {
		return installment;
	}
	public void setInstallment(int installment) {
		this.installment = installment;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ReceiptVo [no=" + no + ", paymentOption=" + paymentOption + ", cardApprovalCode=" + cardApprovalCode
				+ ", installment=" + installment + ", account=" + account + ", name=" + name + "]";
	}
}
