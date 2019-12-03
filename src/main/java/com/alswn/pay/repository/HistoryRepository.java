package com.alswn.pay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alswn.pay.dto.CustomerResDto;
import com.alswn.pay.entity.History;
import com.alswn.pay.entity.HistoryId;

public interface HistoryRepository extends JpaRepository<History, HistoryId> {
	
	@Query(value = "select top 1 substring(h.tr_time,1,4) as year, h.Customer.name as name, h.Customer.acct_no as acctNo, sum(h.tr_amt) as sumAmt" +
			"from history h " +
			"where h.status = false " +
	        "group by h.year, h.customer_num " +
	        "order by sum_amt desc", nativeQuery = true)
	List<CustomerResDto> findTopCustomer();

}
