package com.alswn.pay.service;

import java.util.List;

import com.alswn.pay.dto.CustomerResDto;
import com.alswn.pay.entity.History;

public interface HistoryService {

	List<CustomerResDto> findTopCustomer();

	void save(List<History> histories);

	List<CustomerResDto> findNoneCustomer();

}
