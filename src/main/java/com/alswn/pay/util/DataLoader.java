package com.alswn.pay.util;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.alswn.pay.entity.Branch;
import com.alswn.pay.entity.CsvBranch;
import com.alswn.pay.entity.CsvCustomer;
import com.alswn.pay.entity.CsvHistory;
import com.alswn.pay.entity.Customer;
import com.alswn.pay.entity.History;
import com.alswn.pay.entity.HistoryId;
import com.alswn.pay.service.BranchService;
import com.alswn.pay.service.CustomerService;
import com.alswn.pay.service.HistoryService;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private BranchService branchService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private HistoryService historyService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		InputStream resource = new ClassPathResource("data/데이터_관리점정보.csv").getInputStream();
		List<CsvBranch> csvBranches = DataUtil.read(CsvBranch.class, resource, "Branch");
		List<Branch> branches = new ArrayList<>();
		for(CsvBranch csvBranch : csvBranches){
			Branch branch = new Branch();
			branch.setCode(csvBranch.getCode());
			branch.setName(csvBranch.getName());
			branches.add(branch);
		}
		branchService.save(branches);
		
		resource = new ClassPathResource("data/데이터_계좌정보.csv").getInputStream();
		List<CsvCustomer> csvCustomers = DataUtil.read(CsvCustomer.class, resource, "Customer");
		List<Customer> customers = new ArrayList<>();
		for(CsvCustomer csvCustomer : csvCustomers){
			Customer customer = new Customer();
			customer.setAcctNo(csvCustomer.getAcctNo());
			customer.setName(csvCustomer.getName());
			Branch branch = branchService.findByCode(csvCustomer.getCode());
			customer.setBranch(branch);
			customers.add(customer);
		}
		customerService.save(customers);
		
		resource = new ClassPathResource("data/데이터_거래내역.csv").getInputStream();
		List<CsvHistory> csvHistories = DataUtil.read(CsvHistory.class, resource, "History");
		List<History> histories = new ArrayList<>();
		for(CsvHistory csvHistory : csvHistories){
			History history = new History();
			history.setTrComm(csvHistory.getTrComm());
			history.setTrAmt(csvHistory.getTrAmt());
			history.setStatus(csvHistory.getStatus());
			Customer customer = customerService.findByAcctNo(csvHistory.getAcctNo());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			Date time = simpleDateFormat.parse(csvHistory.getTrTime());
			HistoryId historyId = new HistoryId(time, customer, csvHistory.getSeq());
			history.setHistoryId(historyId);
			histories.add(history);
		}
		historyService.save(histories);
	}

}
