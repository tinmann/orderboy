package com.starter.orderBoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.orderBoy.pojo.ItemDetails;
import com.starter.orderBoy.pojo.UserDetailsPojo;
import com.starter.orderBoy.pojo.UserItemsDealerMapper;

public interface ItemsDealerMapperRepository extends JpaRepository<UserItemsDealerMapper, Long> {
	
	UserItemsDealerMapper findByUserDetailsAndItemDetails(UserDetailsPojo userDetails,ItemDetails itemDetails);

}
