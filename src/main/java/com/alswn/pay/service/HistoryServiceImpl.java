package com.alswn.pay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alswn.pay.dto.CustomerResDto;
import com.alswn.pay.entity.History;
import com.alswn.pay.repository.HistoryRepository;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	private HistoryRepository historyRepository;
	
	@Override
	public List<CustomerResDto> findTopCustomer() {
		
		List<CustomerResDto> customerResDtos = new ArrayList<>();
		List<History> histories = historyRepository.findTopCustomer();
		for(History history : histories){
			CustomerResDto customerResDto = new CustomerResDto();
			customerResDto.setAcctNo(history.getHistoryId().getCustomer().getAcctNo());
			customerResDto.setName(history.getHistoryId().getCustomer().getName());
			customerResDto.setSumAmt(history.getTrAmt());
			customerResDto.setYear(history.getHistoryId().getTrTime().getYear());
			customerResDtos.add(customerResDto);
		}
		
		return customerResDtos;
	}

	@Override
	public void save(List<History> histories) {
		historyRepository.saveAll(histories);
		
	}

	@Override
	public List<CustomerResDto> findNoneCustomer() {

		List<History> histories = historyRepository.findNoneCustomer();
		
		return null;
	}

}
