package com.alswn.pay.service;

import java.util.List;

import com.alswn.pay.dto.BranchResDto;
import com.alswn.pay.dto.CustomerResDto;
import com.alswn.pay.dto.TotalBranchResDto;
import com.alswn.pay.entity.History;

public interface HistoryService {

	List<CustomerResDto> findTopCustomer();

	List<CustomerResDto> findNoneCustomer();

	BranchResDto findByBranch(String brName);

	void save(List<History> histories);

	List<TotalBranchResDto> findAllOrderByAmt();

	BranchResDto findByMergedBranch(String brName, String string);

	

}
