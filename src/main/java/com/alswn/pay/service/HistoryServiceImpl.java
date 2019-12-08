package com.alswn.pay.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alswn.pay.dto.BranchResDto;
import com.alswn.pay.dto.CustomerResDto;
import com.alswn.pay.dto.TotalBranchResDto;
import com.alswn.pay.entity.History;
import com.alswn.pay.repository.HistoryRepository;

@Service
public class HistoryServiceImpl implements HistoryService {
	
	@Autowired
	private HistoryRepository historyRepository;
	
	@Override
	public List<CustomerResDto> findTopCustomer() {
		List<CustomerResDto> customerResDtos = historyRepository.findTopCustomerGroupByTrTimeOrderBySumAmt();
		Map<String, List<CustomerResDto>> groupingCustomerResDtos = customerResDtos.stream().collect(Collectors.groupingBy(CustomerResDto::getYear));
		List<CustomerResDto> resultCustomerResDtos = new ArrayList<CustomerResDto>();
		for( String year : groupingCustomerResDtos.keySet() ){
			CustomerResDto customerResDto = new CustomerResDto(groupingCustomerResDtos.get(year).get(0).getYear(), groupingCustomerResDtos.get(year).get(0).getName(), groupingCustomerResDtos.get(year).get(0).getAcctNo(), groupingCustomerResDtos.get(year).get(0).getSumAmt());
			resultCustomerResDtos.add(customerResDto);
        }
		
		return resultCustomerResDtos;
	}

	@Override
	public List<CustomerResDto> findNoneCustomer() {
		
		List<CustomerResDto> noneCustomer2018ResDtos =  historyRepository.findNoneCustomerGroupByTrTime("2018");
		for (CustomerResDto customerResDto : noneCustomer2018ResDtos) {
			customerResDto.setYear("2018");
		}
		List<CustomerResDto> noneCustomer2019ResDtos =  historyRepository.findNoneCustomerGroupByTrTime("2019");
		for (CustomerResDto customerResDto : noneCustomer2019ResDtos) {
			customerResDto.setYear("2019");
		}
		List<CustomerResDto> noneCustomerResDtos = new ArrayList<>();
		noneCustomerResDtos.addAll(noneCustomer2019ResDtos);
		noneCustomerResDtos.addAll(noneCustomer2018ResDtos);
		return noneCustomerResDtos;
	}

	@Override
	public BranchResDto findByBranch(String brName) {
		
		BranchResDto branchResDto = historyRepository.findByBranchName(brName);
		
		return branchResDto;
	}

	@Override
	public void save(List<History> histories) {
		
		historyRepository.saveAll(histories);
	}

	@Override
	public List<TotalBranchResDto> findAllOrderByAmt() {

		List<TotalBranchResDto> totalBranchResDtos = new ArrayList<TotalBranchResDto>();
		List<BranchResDto> branchResDtos = historyRepository.findByYearOrderByAmt("2018");
		
		TotalBranchResDto totalBranchResDto = new TotalBranchResDto();
		totalBranchResDto.setYear(Long.parseLong("2018"));
		totalBranchResDto.setDataList(branchResDtos);
		totalBranchResDtos.add(totalBranchResDto);
		
		branchResDtos = historyRepository.findByYearOrderByAmt("2019");
		totalBranchResDto = new TotalBranchResDto();
		totalBranchResDto.setYear(Long.parseLong("2019"));
		totalBranchResDto.setDataList(branchResDtos);
		totalBranchResDtos.add(totalBranchResDto);
		
		return totalBranchResDtos;
	}

	@Override
	public BranchResDto findByMergedBranch(String brName, String mgBrName) {
		
		BranchResDto branchResDto = historyRepository.findByBranchName(brName);
		BranchResDto mergedBranchResDto = historyRepository.findByBranchName(mgBrName);
		
		branchResDto.setSumAmt(branchResDto.getSumAmt() + mergedBranchResDto.getSumAmt());
		
		return branchResDto;
	}
}
