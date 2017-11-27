package com.starter.orderBoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.orderBoy.entity.ItemDetails;
import com.starter.orderBoy.entity.UserDetailsPojo;
import com.starter.orderBoy.entity.UserItemsShopMapper;

public interface ItemsShopMapperRepository extends JpaRepository<UserItemsShopMapper, Long> {
	
	UserItemsShopMapper findByUserDetailsAndItemDetails(UserDetailsPojo userDetails,ItemDetails temDetails);

}
