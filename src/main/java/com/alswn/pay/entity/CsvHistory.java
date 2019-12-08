package com.alswn.pay.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CsvHistory {
	//거래일자,계좌번호,거래번호,금액,수수료,취소여부
	//20180102,11111111,1,1000000,0,N
	//20180203,11111111,1,500000,1000,Y
	
	private String trTime;

	private String acctNo;
	
	private int seq;
	
	private double trAmt;
	
	private double trComm;

	private String status;

	public String getTrTime() {
		return trTime;
	}

	public void setTrTime(String trTime) {
		this.trTime = trTime;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public double getTrAmt() {
		return trAmt;
	}

	public void setTrAmt(double trAmt) {
		this.trAmt = trAmt;
	}

	public double getTrComm() {
		return trComm;
	}

	public void setTrComm(double trComm) {
		this.trComm = trComm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
