package com.alswn.pay.dto;

public class CustomerResDto {
//	[
//	{“year”:2018,
//	   “name”:”계좌명”,
//	   “acctNo”:”계좌번호”, 
//		“sumAmt”:0000}
//	{“year”:2019,
//	   “name”:”계좌명”,
//	   “acctNo”:”계좌번호”,
//		“sumAmt”:0000}
//	]
	
	private long year;
	private String name;
	private String acctNo;
	private double sumAmt;
	
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public double getSumAmt() {
		return sumAmt;
	}
	public void setSumAmt(double sumAmt) {
		this.sumAmt = sumAmt;
	}
	
}
