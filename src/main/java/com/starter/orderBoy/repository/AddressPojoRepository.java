package com.starter.orderBoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.orderBoy.pojo.AddressPojo;


public interface AddressPojoRepository extends JpaRepository<AddressPojo, Long> {

}
