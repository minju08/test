package com.alswn.pay.service;

import java.util.List;

import com.alswn.pay.dto.CustomerResDto;

public interface HistoryService {

	List<CustomerResDto> findTopCustomer();

}
