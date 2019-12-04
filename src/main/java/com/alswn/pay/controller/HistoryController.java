package com.alswn.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alswn.pay.dto.TotalBranchResDto;
import com.alswn.pay.entity.History;
import com.alswn.pay.repository.HistoryRepository;

@RestController
@RequestMapping(value="/history")
public class HistoryController {
	
	@Autowired
	private HistoryRepository historyRepository;
	
	@GetMapping(value = "")
	public ResponseEntity<TotalBranchResDto> getHistory(){
		
		History history = historyRepository.findTop1ByStatus("N");
		String acctNo = history.getHistoryId().getCustomer().getAcctNo();
		
		return null;
	}

}
