package com.alswn.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alswn.pay.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, String> {

}
