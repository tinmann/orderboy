package com.starter.orderBoy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starter.orderBoy.entity.ItemDealerListClass;
import com.starter.orderBoy.entity.ItemListClass;
import com.starter.orderBoy.pojo.HsnTable;
import com.starter.orderBoy.pojo.ItemDetails;
import com.starter.orderBoy.pojo.UserItemsDealerMapper;
import com.starter.orderBoy.pojo.UserPojo;
import com.starter.orderBoy.repository.HsnRepository;
import com.starter.orderBoy.repository.ItemDetailsRepository;
import com.starter.orderBoy.repository.ItemsDealerMapperRepository;
import com.starter.orderBoy.repository.ItemsRetailerMapperRepository;
import com.starter.orderBoy.repository.UserDetailsPojoRepository;
import com.starter.orderBoy.repository.UserPojoRepository;

@Component
@Transactional
@Repository
public class DealerItemDao {
	
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
	private ItemsDealerMapperRepository itemsDealerMapperRepository;
	
	@Autowired
	private ItemsRetailerMapperRepository itemsRetailerMapperRepository;
	
	@Autowired
	private HsnRepository hsnRepository;
	
	public List<ItemDetails> hsnItemDetails(String hsnNumber)
	{
		/*try
		{*/
		HsnTable ssnObject = (HsnTable) entityManager.createQuery(
				"select ssnObj from HsnTable ssnObj where ssnObj.ssnNumber = ?1",HsnTable.class)
			    .setParameter(1,  hsnNumber)
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
	
	public List<UserItemsDealerMapper> itemUploadSave(ItemDealerListClass itemDealerListClass)
	{
		
         UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
		itemDealerListClass.getUserItemsDealerMapperList().forEach(itemDealerMapper-> {  
			     if(itemDealerMapper.getItemDetails().getHsnObject()!= null)
			     {
			    	 if(hsnRepository.findByHsnNumber(itemDealerMapper.getItemDetails().getHsnObject().getHsnNumber())!= null)
			    	 {
			    		 itemDealerMapper.getItemDetails().setHsnObject(hsnRepository.findByHsnNumber(itemDealerMapper.getItemDetails().getHsnObject().getHsnNumber()));
			    	 }
			    	 else
			    	 {
			    		 hsnRepository.saveAndFlush(itemDealerMapper.getItemDetails().getHsnObject());			    		 
			    		 itemDealerMapper.getItemDetails().setHsnObject(hsnRepository.findByHsnNumber(itemDealerMapper.getItemDetails().getHsnObject().getHsnNumber()));
			    	 }
			     }
			     else
			     {
			    	 itemDealerMapper.getItemDetails().setHsnObject(null);
			     }
			    
			     ItemDetails updateItem;
			     
			     if(itemDetailsRepository.findByName(itemDealerMapper.getItemDetails().getName())!=null)
			     {
			    	 updateItem = itemDetailsRepository.findByName(itemDealerMapper.getItemDetails().getName());
			    	 updateItem.setQuantity(updateItem.getQuantity()+itemDealerMapper.getQuantity());
			    	 if(updateItem.getHsnObject().getHsnNumber() == null || updateItem.getHsnObject().getHsnNumber() == "")
			    	 {
			    		 if(itemDealerMapper.getItemDetails().getHsnObject()!= null)
			    		 {
			    			 updateItem.setHsnObject(itemDealerMapper.getItemDetails().getHsnObject());
			    		 }
			    		 
			    		 // changes here for future
			    	 }
			    	 itemDetailsRepository.save(updateItem);
			    	 if( itemsDealerMapperRepository.findByUserDetailsAndItemDetails(validUserObject.getUserDetailsPojo(), updateItem) != null)		
					    {
			    		 UserItemsDealerMapper userItemsDealerMapperExists = itemsDealerMapperRepository.findByUserDetailsAndItemDetails(validUserObject.getUserDetailsPojo(), updateItem);
			    		 userItemsDealerMapperExists.setQuantity(userItemsDealerMapperExists.getQuantity()+itemDealerMapper.getQuantity());
			    		 itemsDealerMapperRepository.saveAndFlush(userItemsDealerMapperExists);
					    }
					    
					    else
					    {
					    	 UserItemsDealerMapper dealerMapper = new UserItemsDealerMapper();
						     dealerMapper.setUserDetails(validUserObject.getUserDetailsPojo());
						     dealerMapper.setItemDetails(updateItem);
						     dealerMapper.setQuantity(itemDealerMapper.getQuantity());						     
					    	 itemsDealerMapperRepository.saveAndFlush(dealerMapper);
					    }
			    
			     }
			     else
			     {
			    	 UserItemsDealerMapper dealerMapper = new UserItemsDealerMapper();
				     dealerMapper.setUserDetails(validUserObject.getUserDetailsPojo());
				     dealerMapper.setQuantity(itemDealerMapper.getQuantity());			    	 
			    	 itemDetailsRepository.saveAndFlush(itemDealerMapper.getItemDetails());
			    	 entityManager.refresh(itemDealerMapper.getItemDetails());
			    	 updateItem = itemDetailsRepository.findByName(itemDealerMapper.getItemDetails().getName());
			    	 dealerMapper.setItemDetails(updateItem);
			    	 itemsDealerMapperRepository.saveAndFlush(dealerMapper);
			    	
			     }
			  
			     
		});
		
		return validUserObject.getUserDetailsPojo().getUserItemsDealerMapper();
	}
	
	public UserItemsDealerMapper getDealerMapperEditValues(int itemMapId)
	{
		UserItemsDealerMapper userItemsDealerMapper= itemsDealerMapperRepository.findOne((long) itemMapId);
		
		UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
		
		if(userItemsDealerMapper!= null)
		{
			if(userItemsDealerMapper.getUserDetails().getId() == validUserObject.getUserDetailsPojo().getId())
			{
				return userItemsDealerMapper;
			}
			else
			{
				return null;
			}
		}
		
		
		return null;
	}
	
	public UserItemsDealerMapper saveEditDealerMapperValues(UserItemsDealerMapper editSingleItemForm)
	{
        UserItemsDealerMapper userItemsDealerMapper= itemsDealerMapperRepository.findOne((long) editSingleItemForm.getId());
		
		UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
		if(userItemsDealerMapper!= null)
		{
			if(userItemsDealerMapper.getUserDetails().getId() == validUserObject.getUserDetailsPojo().getId())
			{
				ItemDetails itemToedit = userItemsDealerMapper.getItemDetails();
				itemToedit.setQuantity((itemToedit.getQuantity()-userItemsDealerMapper.getQuantity())+editSingleItemForm.getQuantity());
				itemDetailsRepository.saveAndFlush(itemToedit);
				userItemsDealerMapper.setQuantity(editSingleItemForm.getQuantity());
				itemsDealerMapperRepository.saveAndFlush(userItemsDealerMapper);
				
				return userItemsDealerMapper;
			}
			else
			{
				return null;
			}
		}
		
		return null;
	}
	
	public String deleteDealerMapperValues(int dealerMapperIdToDelete)
	{
        UserItemsDealerMapper userItemsDealerMapper= itemsDealerMapperRepository.findOne((long) dealerMapperIdToDelete);		
		UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
		if(userItemsDealerMapper!= null)
		{
			if(userItemsDealerMapper.getUserDetails().getId() == validUserObject.getUserDetailsPojo().getId())
			{
				ItemDetails itemToedit = userItemsDealerMapper.getItemDetails();
				itemToedit.setQuantity(itemToedit.getQuantity()-userItemsDealerMapper.getQuantity());
				itemDetailsRepository.saveAndFlush(itemToedit);
				itemsDealerMapperRepository.delete(userItemsDealerMapper);
				itemsDealerMapperRepository.flush();
				
				return "Success";
			}
			else 
				return "Failure";
		}
		else
			return "Failure";
	}


}
