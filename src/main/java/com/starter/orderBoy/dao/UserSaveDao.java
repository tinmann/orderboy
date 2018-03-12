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

import com.starter.orderBoy.entity.SearchItems;
import com.starter.orderBoy.pojo.AddressPojo;
import com.starter.orderBoy.pojo.ItemDetails;
import com.starter.orderBoy.pojo.UserDetailsPojo;
import com.starter.orderBoy.pojo.UserItemsDealerMapper;
import com.starter.orderBoy.pojo.UserItemsRetailerMapper;
import com.starter.orderBoy.pojo.UserPojo;
import com.starter.orderBoy.repository.AddressPojoRepository;
import com.starter.orderBoy.repository.ItemDetailsRepository;
import com.starter.orderBoy.repository.ItemsDealerMapperRepository;
import com.starter.orderBoy.repository.ItemsRetailerMapperRepository;
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
	private AddressPojoRepository addressPojoRepository;
	
	@Autowired
	private UserDetailsPojoRepository userDetailsPojoRepository;
	
	@Autowired
	private UserPojoRepository userPojoRepository;
	
	@Autowired
	private ItemDetailsRepository itemDetailsRepository;
	
	@Autowired
	private ItemsDealerMapperRepository itemsDealerMapperRepository;
	
	@Autowired
	private ItemsRetailerMapperRepository itemsRetailerMapperRepository;
	
	public UserDetailsPojo registerUser(UserDetailsPojo userDetailsPojo) throws Exception
	{
		
		userDetailsPojo.setStatus("ACTIVE");
		UserPojo userPojo= userDetailsPojo.getUserPojo();
		userPojo.setUserDetailsPojo(userDetailsPojo);
		userDetailsPojo.setUserPojo(userPojo);
		
		AddressPojo addressPojo = userDetailsPojo.getAddress();
		addressPojo.setUserDetailsPojo(userDetailsPojo);
		userDetailsPojo.setAddress(addressPojo);
		
		
		userDetailsPojoRepository.saveAndFlush(userDetailsPojo);
		entityManager.refresh(userDetailsPojo);
		/*addressPojo.setUserDetailsPojo(userDetailsPojo);
		addressPojoRepository.saveAndFlush(addressPojo);*/
		
		return userDetailsPojo;
	}
	
	public UserPojo loginUser(UserPojo userPojo) throws Exception
	{		
	  UserPojo fetchedObject = userPojoRepository.findByLoginIdAndPassword(userPojo.getLoginId(),userPojo.getPassword());		   
	  return (fetchedObject==null) ? null : fetchedObject;
		
	}
	
	public List<ItemDetails> getItemDetailsForDealer(SearchItems searchItems)// throws Exception
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
			List<UserItemsDealerMapper> testDetail = userDetailsObject.getUserItemsDealerMapper();
			// Removing the old change				
			for(UserItemsDealerMapper toDelete:testDetail)
			{						
				itemsDealerMapperRepository.delete(toDelete);
				itemsDealerMapperRepository.flush();
			}
		
			/// Adding the new Changes
			for(ItemCheckedPojo itemCheckedPojo:itemCheckedListPojo.getItemCheckedList())
			{
				if(itemCheckedPojo.getChecked() == 1)
				{
				ItemDetails ItemDetail = itemDetailsRepository.findOne(itemCheckedPojo.getItemObj().getId());
				UserItemsDealerMapper userItemsDealerMapper = new UserItemsDealerMapper();
				userItemsDealerMapper.setItemDetails(ItemDetail);
				userItemsDealerMapper.setUserDetails(userDetailsObject);
				itemsDealerMapperRepository.save(userItemsDealerMapper);
				//entityManager.persist(userItemsShopMapper);				
				}
			}
			
		}
		else if(userDetailsObject.getType().equals("Customer"))
		{
			List<UserItemsRetailerMapper> testDetail = userDetailsObject.getUserItemsRetailerMapper();
			// Removing the old change			
			for(UserItemsRetailerMapper toDelete:testDetail)
			{				
				itemsRetailerMapperRepository.delete(toDelete);
				itemsRetailerMapperRepository.flush();
			}
			/// Adding the new Changes
			for(ItemCheckedPojo itemCheckedPojo:itemCheckedListPojo.getItemCheckedList())
			{
				if(itemCheckedPojo.getChecked() == 1)
				{
				ItemDetails ItemDetail = entityManager.find(ItemDetails.class, itemCheckedPojo.getItemObj().getId());				
				UserItemsRetailerMapper userItemsRetailerMapper = new UserItemsRetailerMapper();
				userItemsRetailerMapper.setItemDetails(ItemDetail);
				userItemsRetailerMapper.setUserDetails(userDetailsObject);
				//entityManager.persist(userItemsCustomerMapper);		
				itemsRetailerMapperRepository.save(userItemsRetailerMapper);
				}
			}
			
		}
		entityManager.persist(userDetailsObject);
		entityManager.flush();
		//userDetailsPojoRepository.saveAndFlush(userDetailsObject);
		
		return "success";
	}
	
	public List<UserItemsDealerMapper> getPreviousItemDetailsForDealer()
	{
        UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		
        UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
	
		UserDetailsPojo userDetailsObject = validUserObject.getUserDetailsPojo();
		
		List<UserItemsDealerMapper> previousUserItemDealerMapperList  = new ArrayList<UserItemsDealerMapper>();
		
		if(userDetailsObject.getType().equals("Retailer"))
		{
			previousUserItemDealerMapperList = userDetailsObject.getUserItemsDealerMapper();
			
		}
		
		return previousUserItemDealerMapperList;
	}
	
	public List<UserItemsRetailerMapper> getPreviousItemDetailsForRetailer()
	{
        UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		
        UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
	
		UserDetailsPojo userDetailsObject = validUserObject.getUserDetailsPojo();
		
		List<UserItemsRetailerMapper> previousUserItemRetailerMapperList  = new ArrayList<UserItemsRetailerMapper>();
		
		if(userDetailsObject.getType().equals("Customer"))
		{
			previousUserItemRetailerMapperList = userDetailsObject.getUserItemsRetailerMapper();
			
		}
		
		return previousUserItemRetailerMapperList;
	}
	
	public UserDetailsPojo editUserDetailsUser(UserDetailsPojo userDetailsPojo)
	{
		userDetailsPojoRepository.saveAndFlush(userDetailsPojo);
		entityManager.refresh(userDetailsPojo);
		
		return userDetailsPojo;
	}
	
}
