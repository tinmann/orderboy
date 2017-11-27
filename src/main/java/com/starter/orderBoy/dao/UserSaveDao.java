package com.starter.orderBoy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starter.orderBoy.entity.ItemCheckedListPojo;
import com.starter.orderBoy.entity.ItemCheckedPojo;
import com.starter.orderBoy.entity.ItemDetails;
import com.starter.orderBoy.entity.SearchItems;
import com.starter.orderBoy.entity.UserDetailsPojo;
import com.starter.orderBoy.entity.UserItemsCustomerMapper;
import com.starter.orderBoy.entity.UserItemsShopMapper;
import com.starter.orderBoy.entity.UserPojo;
import com.starter.orderBoy.repository.ItemDetailsRepository;
import com.starter.orderBoy.repository.ItemsCustomerMapperRepository;
import com.starter.orderBoy.repository.ItemsShopMapperRepository;
import com.starter.orderBoy.repository.UserDetailsPojoRepository;
import com.starter.orderBoy.repository.UserPojoRepository;


@Component
@Transactional
@Repository
public class UserSaveDao {
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private UserDetailsPojoRepository userDetailsPojoRepository;
	
	@Autowired
	private UserPojoRepository userPojoRepository;
	
	@Autowired
	private ItemDetailsRepository itemDetailsRepository;
	
	@Autowired
	private ItemsShopMapperRepository itemsShopMapperRepository;
	
	@Autowired
	private ItemsCustomerMapperRepository itemsCustomerMapperRepository;
	
	public UserDetailsPojo registerUser(UserDetailsPojo userDetailsPojo) throws Exception
	{
		
		userDetailsPojo.setStatus("ACTIVE");
		UserPojo userPojo= userDetailsPojo.getUserPojo();
		userPojo.setUserDetailsPojo(userDetailsPojo);
		userDetailsPojo.setUserPojo(userPojo);
		
		userDetailsPojoRepository.saveAndFlush(userDetailsPojo);
		entityManager.refresh(userDetailsPojo);
		
		return userDetailsPojo;
	}
	
	public UserPojo loginUser(UserPojo userPojo) throws Exception
	{		
	  UserPojo fetchedObject = userPojoRepository.findByLoginIdAndPassword(userPojo.getLoginId(),userPojo.getPassword());		   
	  return (fetchedObject==null) ? null : fetchedObject;
		
	}
	
	public List<ItemDetails> getItemDetailsForShopkeeper(SearchItems searchItems)// throws Exception
	{
	  return itemDetailsRepository.findAll();	
	}
	
	public String addUserItem(ItemCheckedListPojo itemCheckedListPojo)
	{
		UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		
		UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
	
		UserDetailsPojo userDetailsObject = validUserObject.getUserDetailsPojo();
		
		if(userDetailsObject.getType().equals("Retailer"))
		{
			List<UserItemsShopMapper> testDetail = userDetailsObject.getUserItemsShopMapper();
			// Removing the old change				
			for(UserItemsShopMapper toDelete:testDetail)
			{						
				itemsShopMapperRepository.delete(toDelete);
				itemsShopMapperRepository.flush();
			}
		
			/// Adding the new Changes
			for(ItemCheckedPojo itemCheckedPojo:itemCheckedListPojo.getItemCheckedList())
			{
				if(itemCheckedPojo.getChecked() == 1)
				{
				ItemDetails ItemDetail = itemDetailsRepository.findOne(itemCheckedPojo.getItemObj().getId());
				UserItemsShopMapper userItemsShopMapper = new UserItemsShopMapper();
				userItemsShopMapper.setItemDetails(ItemDetail);
				userItemsShopMapper.setUserDetails(userDetailsObject);
				itemsShopMapperRepository.save(userItemsShopMapper);
				//entityManager.persist(userItemsShopMapper);				
				}
			}
			
		}
		else if(userDetailsObject.getType().equals("Customer"))
		{
			List<UserItemsCustomerMapper> testDetail = userDetailsObject.getUserItemsCustomerMapper();
			// Removing the old change			
			for(UserItemsCustomerMapper toDelete:testDetail)
			{				
				itemsCustomerMapperRepository.delete(toDelete);
				itemsCustomerMapperRepository.flush();
			}
			/// Adding the new Changes
			for(ItemCheckedPojo itemCheckedPojo:itemCheckedListPojo.getItemCheckedList())
			{
				if(itemCheckedPojo.getChecked() == 1)
				{
				ItemDetails ItemDetail = entityManager.find(ItemDetails.class, itemCheckedPojo.getItemObj().getId());				
				UserItemsCustomerMapper userItemsCustomerMapper = new UserItemsCustomerMapper();
				userItemsCustomerMapper.setItemDetails(ItemDetail);
				userItemsCustomerMapper.setUserDetails(userDetailsObject);
				//entityManager.persist(userItemsCustomerMapper);		
				itemsCustomerMapperRepository.save(userItemsCustomerMapper);
				}
			}
			
		}
		entityManager.persist(userDetailsObject);
		entityManager.flush();
		//userDetailsPojoRepository.saveAndFlush(userDetailsObject);
		
		return "success";
	}
	
	public List<UserItemsShopMapper> getPreviousItemDetailsForShopkeeper()
	{
        UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		
        UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
	
		UserDetailsPojo userDetailsObject = validUserObject.getUserDetailsPojo();
		
		List<UserItemsShopMapper> previousUserItemShopMapperList  = new ArrayList<UserItemsShopMapper>();
		
		if(userDetailsObject.getType().equals("Retailer"))
		{
			previousUserItemShopMapperList = userDetailsObject.getUserItemsShopMapper();
			
		}
		
		return previousUserItemShopMapperList;
	}
	
	public List<UserItemsCustomerMapper> getPreviousItemDetailsForCustomer()
	{
        UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		
        UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
	
		UserDetailsPojo userDetailsObject = validUserObject.getUserDetailsPojo();
		
		List<UserItemsCustomerMapper> previousUserItemCustomerMapperList  = new ArrayList<UserItemsCustomerMapper>();
		
		if(userDetailsObject.getType().equals("Customer"))
		{
			previousUserItemCustomerMapperList = userDetailsObject.getUserItemsCustomerMapper();
			
		}
		
		return previousUserItemCustomerMapperList;
	}
	
}
