package com.alswn.pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alswn.pay.entity.Customer;
import com.alswn.pay.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void save(List<Customer> customers) {
		customerRepository.saveAll(customers);
	}

	@Override
	public Customer findByAcctNo(String acctNo) {
		return customerRepository.findById(acctNo).get();
	}

}
