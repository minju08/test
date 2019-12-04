package com.alswn.pay.service;

import java.util.List;

import com.alswn.pay.entity.Customer;

public interface CustomerService {

	void save(List<Customer> customers);

	Customer findByAcctNo(String acctNo);

}
