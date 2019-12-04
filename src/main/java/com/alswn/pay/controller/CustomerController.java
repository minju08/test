package com.alswn.pay.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alswn.pay.dto.CustomerResDto;
import com.alswn.pay.entity.Customer;
import com.alswn.pay.repository.CustomerRepository;
import com.alswn.pay.service.HistoryService;
import com.alswn.pay.util.DataUtil;


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
	public ResponseEntity<List<CustomerResDto>> getTopCustomer(){
//		select * from history group by year, account top 1
		List<CustomerResDto> customerResDtos = historyService.findTopCustomer();
		
		return null;
	}
	
	
//	2018년 또는 2019년에 거래가 없는 고객을 추출하는 API 개발.
//	(취소여부가 ‘Y’ 거래는 취소된 거래임)
	@GetMapping(value = "/none")
	public ResponseEntity<List<CustomerResDto>> getNoneCustomer(){
		
		return null;
	}
	
	@PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException {
        customerRepository.saveAll(DataUtil.read(Customer.class, file.getInputStream(), file.getName()));
    }


}
