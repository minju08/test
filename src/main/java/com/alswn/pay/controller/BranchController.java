package com.alswn.pay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alswn.pay.dto.BranchResDto;
import com.alswn.pay.dto.TotalBranchResDto;
import com.alswn.pay.repository.BranchRepository;
import com.alswn.pay.service.HistoryService;

@RestController
@RequestMapping(value = "/branch")
public class BranchController {
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private BranchRepository branchRepository;
	
	
	
//	연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 개발.
//	( 취소여부가 ‘Y’ 거래는 취소된 거래임)
	@GetMapping(value = "")
	public List<TotalBranchResDto> getBranches(){
		
		List<TotalBranchResDto> totalBranchResDto = historyService.findAllOrderByAmt();
		return totalBranchResDto;
	}

//	분당점과 판교점을 통폐합하여 판교점으로 관리점 이관을 하였습니다.
//	지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API 개발
//	( 취소여부가 ‘Y’ 거래는 취소된 거래임,)
//	{
//		“brName”:”관리점명”, 
//		 “brCode”:”관리점코드”,  “sumAmt”:0000
//	}

	@PostMapping(value = "")
	public Object searchBranch(@RequestBody(required = true) String brName){
		if(brName.equalsIgnoreCase("분당점")){
			return new ResponseEntity<String>("br code not found error", HttpStatus.NOT_FOUND);
		} else if(brName.equalsIgnoreCase("판교점")) {
			BranchResDto branchResDtos = historyService.findByMergedBranch(brName, "분당점");
			return branchResDtos;
		} else {
			BranchResDto branchResDtos = historyService.findByBranch(brName);
			return branchResDtos;
		}
	}

}
