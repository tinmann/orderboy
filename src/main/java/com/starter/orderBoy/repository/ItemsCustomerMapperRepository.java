package com.starter.orderBoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.orderBoy.entity.UserItemsCustomerMapper;

public interface ItemsCustomerMapperRepository extends JpaRepository<UserItemsCustomerMapper, Long> {

}
