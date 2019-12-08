package com.alswn.pay.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class BranchResDto {
//	{
//		“brName”:”관리점명”, 
//		 “brCode”:”관리점코드”, 
//		“sumAmt”:0000
//		}
	
	private String brName;
	private String brCode;
	private double sumAmt;
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getBrCode() {
		return brCode;
	}
	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}
	public double getSumAmt() {
		return sumAmt;
	}
	public void setSumAmt(double sumAmt) {
		this.sumAmt = sumAmt;
	}
	
	public BranchResDto(String brName, String brCode, double sumAmt) {
		super();
		this.brName = brName;
		this.brCode = brCode;
		this.sumAmt = sumAmt;
	}

}
