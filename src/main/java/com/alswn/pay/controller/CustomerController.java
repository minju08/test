package com.alswn.pay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alswn.pay.dto.CustomerResDto;
import com.alswn.pay.repository.CustomerRepository;
import com.alswn.pay.service.HistoryService;


@RestController
@RequestMapping(value = "/cust")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private HistoryService historyService;

//	2018년, 2019년 각 연도별 합계 금액이 가장 많은 고객을 추출하는 API 개발.
//	(단, 취소여부가 ‘Y’ 거래는 취소된 거래임, 합계 금액은 거래금액에서 수수료를 차감한 금액임)
	@GetMapping(value = "")
	public List<CustomerResDto> getTopCustomer(){
		List<CustomerResDto> customerResDtos = historyService.findTopCustomer();
		
		return customerResDtos;
	}
	
	
//	2018년 또는 2019년에 거래가 없는 고객을 추출하는 API 개발.
//	(취소여부가 ‘Y’ 거래는 취소된 거래임)
	@GetMapping(value = "/none")
	public List<CustomerResDto> getNoneCustomer(){
		List<CustomerResDto> customerResDtos = historyService.findNoneCustomer();
		
		return customerResDtos;
	}

}
