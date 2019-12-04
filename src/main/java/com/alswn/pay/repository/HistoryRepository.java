package com.alswn.pay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alswn.pay.entity.History;
import com.alswn.pay.entity.HistoryId;

public interface HistoryRepository extends JpaRepository<History, HistoryId> {
	
	@Query(value = "select * " +
//			"substring(h.tr_time,1,4) as year, " + 
//			"h.historyId.customer.name as name, " + 
//			"h.customer_acct_no as acctNo, " +
//			"sum(h.tr_amt) as sumAmt " +
			"from history as h " +
			"where h.status = 'N' " +
	        "group by substring(h.tr_time,1,4), h.customer_acct_no, h.seq " +
	        "order by sum(h.tr_amt) - h.tr_comm desc limit 1", nativeQuery = true)
//	@Query(value = "select * from history h where h.status = 'N' group by substring(h.tr_time,1,4), h.customer_acct_no, h.seq order by sum(h.tr_amt) desc", nativeQuery = true)
	List<History> findTopCustomer();

	History findTop1ByStatus(String status);

	@Query(value = "select * " +
//			"substring(h.tr_time,1,4) as year, " + 
//			"h.historyId.customer.name as name, " + 
//			"h.customer_acct_no as acctNo, " +
//			"sum(h.tr_amt) as sumAmt " +
			"from history as h " +
			"where h.status = 'N' " +
	        "group by substring(h.tr_time,1,4), h.customer_acct_no, h.seq " +
	        "order by sum(h.tr_amt) - h.tr_comm desc limit 1", nativeQuery = true)
	List<History> findNoneCustomer();

}
