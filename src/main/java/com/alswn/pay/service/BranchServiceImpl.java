package com.alswn.pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alswn.pay.entity.Branch;
import com.alswn.pay.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	private BranchRepository branchRepository;

	@Override
	public void save(List<Branch> branches) {
		branchRepository.saveAll(branches);
	}

	@Override
	public Branch findByCode(String code) {
		return branchRepository.findById(code).get();
	}

}
