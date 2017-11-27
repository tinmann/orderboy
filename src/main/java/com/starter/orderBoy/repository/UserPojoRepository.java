package com.starter.orderBoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.orderBoy.entity.UserPojo;

public interface UserPojoRepository extends JpaRepository<UserPojo, Long> {
	
	UserPojo findByLoginIdAndPassword(String loginId, String password);

}
