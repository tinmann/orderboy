package com.starter.orderBoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.orderBoy.pojo.UserDetailsPojo;



public interface UserDetailsPojoRepository extends JpaRepository<UserDetailsPojo, Long> {

}
