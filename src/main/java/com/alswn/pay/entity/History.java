package com.alswn.pay.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class History {
	//거래일자,계좌번호,거래번호,금액,수수료,취소여부
	//20180102,11111111,1,1000000,0,N
	//20180203,11111111,1,500000,1000,Y
	
	@Temporal(TemporalType.DATE)
	@Column(name="tr_time")
	private Date trTime;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="customer_num")
//	private Customer Customer;
	
	@Column(name="acct_no")
	private String acctNo;
	
	@Column(name="seq")
	private int seq;
	
	@Column(name="tr_amt")
	private double trAmt;
	
	@Column(name="tr_comm")
	private double trComm;

	@Column(name="status")
	private boolean status;
	
	
}
