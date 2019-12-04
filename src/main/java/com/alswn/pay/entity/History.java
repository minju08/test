package com.alswn.pay.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "HISTORY")
//@IdClass(HistoryId.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class History {
	
	@EmbeddedId
	private HistoryId historyId;
	
//	@Id
//	@Temporal(TemporalType.DATE)
//	@Column(name="tr_time")
//	private Date trTime;

//	@Id
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "customer_acct_no")
//	private Customer customer;
	
//	@Id
//	@Column(name="seq")
//	private int seq;
	
	@Column(name="tr_amt")
	private double trAmt;
	
	@Column(name="tr_comm")
	private double trComm;

	@Column(name="status")
	private String status;

//	public Date getTrTime() {
//		return trTime;
//	}
//
//	public void setTrTime(Date trTime) {
//		this.trTime = trTime;
//	}
//
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	public int getSeq() {
//		return seq;
//	}
//
//	public void setSeq(int seq) {
//		this.seq = seq;
//	}

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

	public HistoryId getHistoryId() {
		return historyId;
	}

	public void setHistoryId(HistoryId historyId) {
		this.historyId = historyId;
	}
	
	
	
}
