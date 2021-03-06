package com.alswn.pay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "BRANCH")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch {
	
	@Id
	@Column(name="code", nullable = false)
	private String code;
	
	@Column(name="name", nullable = false)
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
