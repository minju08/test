package com.alswn.pay.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@IdClass(HistoryId.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class History {
	//거래일자,계좌번호,거래번호,금액,수수료,취소여부
	//20180102,11111111,1,1000000,0,N
	//20180203,11111111,1,500000,1000,Y
	
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="tr_time")
	private Date trTime;

	@Id
	private Customer Customer;
	
	@Id
	@Column(name="seq")
	private int seq;
	
	@Column(name="tr_amt")
	private double trAmt;
	
	@Column(name="tr_comm")
	private double trComm;

	@Column(name="status")
	private boolean status;
	
	
}
