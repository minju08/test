package com.alswn.pay.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
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
	
	private String year;
	private String name;
	private String acctNo;
	private double sumAmt;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
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
	
	public CustomerResDto(String year, String name, String acctNo, double sumAmt) {
		this.year = year;
		this.name = name;
		this.acctNo = acctNo;
		this.sumAmt = sumAmt;
	}
	
	public CustomerResDto(String name, String acctNo) {
		this.name = name;
		this.acctNo = acctNo;
	}
	
	
}
