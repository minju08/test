package com.alswn.pay.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alswn.pay.dto.BranchResDto;
import com.alswn.pay.dto.TotalBranchResDto;
import com.alswn.pay.entity.Branch;
import com.alswn.pay.repository.BranchRepository;
import com.alswn.pay.util.DataUtil;

@RestController
@RequestMapping(value = "/branch")
public class BranchController {
	
	@Autowired
	private BranchRepository branchRepository;
	
	
	
//	연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 개발.
//	( 취소여부가 ‘Y’ 거래는 취소된 거래임)
	@GetMapping(value = "")
	public ResponseEntity<TotalBranchResDto> getBranches(){
		
		
		return null;
	}

//	분당점과 판교점을 통폐합하여 판교점으로 관리점 이관을 하였습니다.
//	지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API 개발
//	( 취소여부가 ‘Y’ 거래는 취소된 거래임,)
//	{
//		“brName”:”관리점명”, 
//		 “brCode”:”관리점코드”,  “sumAmt”:0000
//		}

	@PostMapping(value = "")
	public ResponseEntity<BranchResDto> searchBranch(@RequestBody(required = true) String brName){
		
		return null;
	}

	
	@PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException {
		
		List<Branch> braches = DataUtil.read(Branch.class, file.getInputStream(), file.getName());
		for(Branch branch : braches){
			System.out.println(branch);
		}
		
        branchRepository.saveAll(braches);
    }

}
