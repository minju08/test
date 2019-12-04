package com.alswn.pay.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class HistoryId implements Serializable {
	
	@Temporal(TemporalType.DATE)
	@Column(name="tr_time")
	private Date trTime;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_acct_no")
	private Customer customer;
	@Column(name="seq")
	private int seq;
	
	
	public HistoryId(Date trTime, Customer customer, int seq) {
		this.trTime = trTime;
		this.customer = customer;
		this.seq = seq;
	}
	
	public HistoryId() {
		
	}

	public Date getTrTime() {
		return trTime;
	}

	public void setTrTime(Date trTime) {
		this.trTime = trTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	

}
