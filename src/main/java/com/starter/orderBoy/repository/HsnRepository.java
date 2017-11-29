package com.starter.orderBoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.orderBoy.pojo.HsnTable;

public interface HsnRepository extends JpaRepository<HsnTable, Long> {
	
	HsnTable findByHsnNumber(String hsnNumber);

}
