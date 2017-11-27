package com.starter.orderBoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.orderBoy.entity.SsnTable;


public interface SsnRepository extends JpaRepository<SsnTable, Long> {
	
	SsnTable findBySsnNumber(String ssnNumber);

}
