package com.alswn.pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alswn.pay.dto.CustomerResDto;
import com.alswn.pay.repository.HistoryRepository;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	private HistoryRepository historyRepository;
	
	@Override
	public List<CustomerResDto> findTopCustomer() {
		return historyRepository.findTopCustomer();
	}

}
