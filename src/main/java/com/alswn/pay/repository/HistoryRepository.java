package com.alswn.pay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alswn.pay.dto.BranchResDto;
import com.alswn.pay.dto.CustomerResDto;
import com.alswn.pay.entity.History;
import com.alswn.pay.entity.HistoryId;

public interface HistoryRepository extends JpaRepository<History, HistoryId> {

	@Query(value="SELECT " +
	   "new com.alswn.pay.dto.CustomerResDto(substring(h.historyId.trTime,1,4), h.historyId.customer.name, h.historyId.customer.acctNo, sum(h.trAmt - h.trComm)) " +
	   "FROM " +
	   "History h " +
	   "WHERE h.status = 'N' " +
	   "GROUP BY " +
	   "substring(h.historyId.trTime,1,4), h.historyId.customer.acctNo, h.historyId.seq "+
	   "ORDER BY " +
	   "substring(h.historyId.trTime,1,4), sum(h.trAmt - h.trComm) DESC", nativeQuery=false)
	List<CustomerResDto> findTopCustomerGroupByTrTimeOrderBySumAmt();


	@Query(value="SELECT " +
			   "new com.alswn.pay.dto.CustomerResDto(c.name, c.acctNo) " +
			   "FROM " +
			   "Customer c " +
			   "WHERE c.acctNo NOT IN " +
			   "(SELECT h.historyId.customer.acctNo FROM History h " +
			   	"WHERE h.status = 'N' AND substring(h.historyId.trTime,1,4) = (?1))", nativeQuery=false)
	List<CustomerResDto> findNoneCustomerGroupByTrTime(String year);

	
	@Query(value="SELECT " +
			   "new com.alswn.pay.dto.BranchResDto(h.historyId.customer.branch.code, h.historyId.customer.branch.name, sum(h.trAmt - h.trComm)) " +
			   "FROM " +
			   "History h " +
			   "WHERE h.status = 'N' AND substring(h.historyId.trTime,1,4) = (?1) " +
			   "GROUP BY " +
			   "substring(h.historyId.trTime,1,4), h.historyId.customer.branch.code "+
			   "ORDER BY " +
			   "substring(h.historyId.trTime,1,4), sum(h.trAmt - h.trComm) DESC", nativeQuery=false)
	List<BranchResDto> findByYearOrderByAmt(String year);

	
	@Query(value="SELECT " +
			   "new com.alswn.pay.dto.BranchResDto(h.historyId.customer.branch.code, h.historyId.customer.branch.name, sum(h.trAmt - h.trComm)) " +
			   "FROM " +
			   "History h " +
			   "WHERE h.status = 'N' AND h.historyId.customer.branch.name = (?1)", nativeQuery=false)
	BranchResDto findByBranchName(String brName);
	

}
