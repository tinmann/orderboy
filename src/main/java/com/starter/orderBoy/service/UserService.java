package com.starter.orderBoy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.starter.orderBoy.dao.UserSaveDao;
import com.starter.orderBoy.entity.ItemCheckedListPojo;
import com.starter.orderBoy.entity.SearchItems;
import com.starter.orderBoy.pojo.ItemDetails;
import com.starter.orderBoy.pojo.UserDetailsPojo;
import com.starter.orderBoy.pojo.UserItemsDealerMapper;
import com.starter.orderBoy.pojo.UserItemsRetailerMapper;
import com.starter.orderBoy.pojo.UserPojo;



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
	public List<ItemDetails> getItemDetailsForDealer(SearchItems searchItems) //throws Exception
	{
		return userSaveDao.getItemDetailsForDealer(searchItems);
	}
	public String addUserItem(ItemCheckedListPojo itemCheckedListPojo)
	{
		return userSaveDao.addUserItem(itemCheckedListPojo);
	}
	
	public List<UserItemsDealerMapper> getPreviousItemDetailsForDealer()
	{
		return userSaveDao.getPreviousItemDetailsForDealer();
	}
	public List<UserItemsRetailerMapper> getPreviousItemDetailsForRetailer()
	{
		return userSaveDao.getPreviousItemDetailsForRetailer();
	}

}
