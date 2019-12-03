package com.alswn.pay.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class HistoryId implements Serializable {
	
	
	private Date trTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_acct_no")
	private Customer Customer;
	private int seq;
	
	
	public HistoryId(Date trTime, Customer customer, int seq) {
		super();
		this.trTime = trTime;
		Customer = customer;
		this.seq = seq;
	}
	
	

}
