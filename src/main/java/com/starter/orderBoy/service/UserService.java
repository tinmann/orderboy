package com.starter.orderBoy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.starter.orderBoy.dao.UserSaveDao;
import com.starter.orderBoy.entity.ItemCheckedListPojo;
import com.starter.orderBoy.entity.ItemDetails;
import com.starter.orderBoy.entity.SearchItems;
import com.starter.orderBoy.entity.UserDetailsPojo;
import com.starter.orderBoy.entity.UserItemsCustomerMapper;
import com.starter.orderBoy.entity.UserItemsShopMapper;
import com.starter.orderBoy.entity.UserPojo;



@Component
public class UserService {
	
	@Autowired UserSaveDao userSaveDao;
	
	public UserDetailsPojo registerUser(UserDetailsPojo userDetailsPojo) throws Exception
	{	
	   return userSaveDao.registerUser(userDetailsPojo);
	}
	
	public UserPojo loginUser(UserPojo userPojo) throws Exception
	{
		return userSaveDao.loginUser(userPojo);
	}
	public List<ItemDetails> getItemDetailsForShopkeeper(SearchItems searchItems) //throws Exception
	{
		return userSaveDao.getItemDetailsForShopkeeper(searchItems);
	}
	public String addUserItem(ItemCheckedListPojo itemCheckedListPojo)
	{
		return userSaveDao.addUserItem(itemCheckedListPojo);
	}
	
	public List<UserItemsShopMapper> getPreviousItemDetailsForShopkeeper()
	{
		return userSaveDao.getPreviousItemDetailsForShopkeeper();
	}
	public List<UserItemsCustomerMapper> getPreviousItemDetailsForCustomer()
	{
		return userSaveDao.getPreviousItemDetailsForCustomer();
	}

}
