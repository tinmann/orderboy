package com.starter.orderBoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.orderBoy.pojo.ItemDetails;


public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Long> {
	
	ItemDetails findByName(String name);

}
