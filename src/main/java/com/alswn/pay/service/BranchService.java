package com.alswn.pay.service;

import java.util.List;

import com.alswn.pay.entity.Branch;

public interface BranchService {

	void save(List<Branch> branches);

	Branch findByCode(String code);

}
