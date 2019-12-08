package com.alswn.pay.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "HISTORY")
@JsonIgnoreProperties(ignoreUnknown = true)
public class History {
	
	@EmbeddedId
	private HistoryId historyId;
	
	@Column(name="tr_amt")
	private double trAmt;
	
	@Column(name="tr_comm")
	private double trComm;

	@Column(name="status")
	private String status;

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
