package com.starter.orderBoy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starter.orderBoy.entity.ItemDetails;
import com.starter.orderBoy.entity.ItemListClass;
import com.starter.orderBoy.entity.SsnTable;
import com.starter.orderBoy.entity.UserItemsCustomerMapper;
import com.starter.orderBoy.entity.UserItemsShopMapper;
import com.starter.orderBoy.entity.UserPojo;
import com.starter.orderBoy.repository.ItemDetailsRepository;
import com.starter.orderBoy.repository.ItemsCustomerMapperRepository;
import com.starter.orderBoy.repository.ItemsShopMapperRepository;
import com.starter.orderBoy.repository.SsnRepository;
import com.starter.orderBoy.repository.UserDetailsPojoRepository;
import com.starter.orderBoy.repository.UserPojoRepository;

@Component
@Transactional
@Repository
public class ItemDao {
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
	
	@Autowired
	private SsnRepository ssnRepository;
	
	public List<ItemDetails> ssnItemDetails(String ssnNumber)
	{
		/*try
		{*/
		SsnTable ssnObject = (SsnTable) entityManager.createQuery(
				"select ssnObj from SsnTable ssnObj where ssnObj.ssnNumber = ?1",SsnTable.class)
			    .setParameter(1,  ssnNumber)
			    .setMaxResults(1)
			    .getSingleResult();
		
		return ssnObject.getItemsList();
	/*	}
		catch(Exception ex)
		{
			return null;
		}*/
	}
	
	public ItemDetails itemFetchDetails(int itemId)
	{
		ItemDetails itemDetails = entityManager.find(ItemDetails.class, itemId);
		
		return itemDetails;
	}
	
	public List<UserItemsShopMapper> itemUploadSave(ItemListClass itemListClass)
	{
		
         UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
		itemListClass.getItemDetailsListConfirm().forEach(item-> {  
			     if(item.getSsnObject()!= null)
			     {
			    	 if(ssnRepository.findBySsnNumber(item.getSsnObject().getSsnNumber())!= null)
			    	 {
			    		 item.setSsnObject(ssnRepository.findBySsnNumber(item.getSsnObject().getSsnNumber()));
			    	 }
			    	 else
			    	 {
			    		 ssnRepository.saveAndFlush(item.getSsnObject());			    		 
			    		 item.setSsnObject(ssnRepository.findBySsnNumber(item.getSsnObject().getSsnNumber()));
			    	 }
			     }
			     else
			     {
			    	 item.setSsnObject(null);
			     }
			    
			     ItemDetails updateItem;
			     
			     if(itemDetailsRepository.findByName(item.getName())!=null)
			     {
			    	 updateItem = itemDetailsRepository.findByName(item.getName());
			    	 updateItem.setQuantity(updateItem.getQuantity()+item.getQuantity());
			    	 if(updateItem.getSsnObject().getSsnNumber() == null || updateItem.getSsnObject().getSsnNumber() == "")
			    	 {
			    		 if(item.getSsnObject()!= null)
			    		 {
			    			 updateItem.setSsnObject(item.getSsnObject());
			    		 }
			    		 
			    		 // changes here for future
			    	 }
			    	 itemDetailsRepository.save(updateItem);
			    	 if( itemsShopMapperRepository.findByUserDetailsAndItemDetails(validUserObject.getUserDetailsPojo(), updateItem) != null)		
					    {
			    		 UserItemsShopMapper userItemsShopMapperExists = itemsShopMapperRepository.findByUserDetailsAndItemDetails(validUserObject.getUserDetailsPojo(), updateItem);
			    		 userItemsShopMapperExists.setQuantity(userItemsShopMapperExists.getQuantity()+item.getQuantity());
			    		 itemsShopMapperRepository.saveAndFlush(userItemsShopMapperExists);
					    }
					    
					    else
					    {
					    	 UserItemsShopMapper shopMapper = new UserItemsShopMapper();
						     shopMapper.setUserDetails(validUserObject.getUserDetailsPojo());
						     shopMapper.setItemDetails(updateItem);
						     shopMapper.setQuantity(item.getQuantity());						     
					    	 itemsShopMapperRepository.saveAndFlush(shopMapper);
					    }
			    
			     }
			     else
			     {
			    	 UserItemsShopMapper shopMapper = new UserItemsShopMapper();
				     shopMapper.setUserDetails(validUserObject.getUserDetailsPojo());
				     shopMapper.setQuantity(item.getQuantity());			    	 
			    	 itemDetailsRepository.saveAndFlush(item);
			    	 entityManager.refresh(item);
			    	 updateItem = itemDetailsRepository.findByName(item.getName());
			    	 shopMapper.setItemDetails(updateItem);
			    	 itemsShopMapperRepository.saveAndFlush(shopMapper);
			    	
			     }
			  
			     
		});
		
		return validUserObject.getUserDetailsPojo().getUserItemsShopMapper();
	}
	
	public UserItemsShopMapper getShopMapperEditValues(int itemMapId)
	{
		UserItemsShopMapper userItemsShopMapper= itemsShopMapperRepository.findOne((long) itemMapId);
		
		UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
		
		if(userItemsShopMapper!= null)
		{
			if(userItemsShopMapper.getUserDetails().getId() == validUserObject.getUserDetailsPojo().getId())
			{
				return userItemsShopMapper;
			}
			else
			{
				return null;
			}
		}
		
		
		return null;
	}
	
	public UserItemsShopMapper saveEditShopMapperValues(UserItemsShopMapper editSingleItemForm)
	{
        UserItemsShopMapper userItemsShopMapper= itemsShopMapperRepository.findOne((long) editSingleItemForm.getId());
		
		UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
		if(userItemsShopMapper!= null)
		{
			if(userItemsShopMapper.getUserDetails().getId() == validUserObject.getUserDetailsPojo().getId())
			{
				ItemDetails itemToedit = userItemsShopMapper.getItemDetails();
				itemToedit.setQuantity((itemToedit.getQuantity()-userItemsShopMapper.getQuantity())+editSingleItemForm.getQuantity());
				itemDetailsRepository.saveAndFlush(itemToedit);
				userItemsShopMapper.setQuantity(editSingleItemForm.getQuantity());
				itemsShopMapperRepository.saveAndFlush(userItemsShopMapper);
				
				return userItemsShopMapper;
			}
			else
			{
				return null;
			}
		}
		
		return null;
	}
	
	public String deleteShopMapperValues(int shopMapperIdToDelete)
	{
        UserItemsShopMapper userItemsShopMapper= itemsShopMapperRepository.findOne((long) shopMapperIdToDelete);		
		UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
		if(userItemsShopMapper!= null)
		{
			if(userItemsShopMapper.getUserDetails().getId() == validUserObject.getUserDetailsPojo().getId())
			{
				ItemDetails itemToedit = userItemsShopMapper.getItemDetails();
				itemToedit.setQuantity(itemToedit.getQuantity()-userItemsShopMapper.getQuantity());
				itemDetailsRepository.saveAndFlush(itemToedit);
				itemsShopMapperRepository.delete(userItemsShopMapper);
				itemsShopMapperRepository.flush();
				
				return "Success";
			}
			else 
				return "Failure";
		}
		else
			return "Failure";
	}

}
