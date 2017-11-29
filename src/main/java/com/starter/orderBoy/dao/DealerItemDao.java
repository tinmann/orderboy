package com.starter.orderBoy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<UserItemsDealerMapper> itemUploadSave(ItemListClass itemListClass)
	{
		
         UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
		UserPojo validUserObject = userPojoRepository.findOne(userObject.getId());
		itemListClass.getItemDetailsListConfirm().forEach(item-> {  
			     if(item.getHsnObject()!= null)
			     {
			    	 if(hsnRepository.findByHsnNumber(item.getHsnObject().getHsnNumber())!= null)
			    	 {
			    		 item.setHsnObject(hsnRepository.findByHsnNumber(item.getHsnObject().getHsnNumber()));
			    	 }
			    	 else
			    	 {
			    		 hsnRepository.saveAndFlush(item.getHsnObject());			    		 
			    		 item.setHsnObject(hsnRepository.findByHsnNumber(item.getHsnObject().getHsnNumber()));
			    	 }
			     }
			     else
			     {
			    	 item.setHsnObject(null);
			     }
			    
			     ItemDetails updateItem;
			     
			     if(itemDetailsRepository.findByName(item.getName())!=null)
			     {
			    	 updateItem = itemDetailsRepository.findByName(item.getName());
			    	 updateItem.setQuantity(updateItem.getQuantity()+item.getQuantity());
			    	 if(updateItem.getHsnObject().getHsnNumber() == null || updateItem.getHsnObject().getHsnNumber() == "")
			    	 {
			    		 if(item.getHsnObject()!= null)
			    		 {
			    			 updateItem.setHsnObject(item.getHsnObject());
			    		 }
			    		 
			    		 // changes here for future
			    	 }
			    	 itemDetailsRepository.save(updateItem);
			    	 if( itemsDealerMapperRepository.findByUserDetailsAndItemDetails(validUserObject.getUserDetailsPojo(), updateItem) != null)		
					    {
			    		 UserItemsDealerMapper userItemsDealerMapperExists = itemsDealerMapperRepository.findByUserDetailsAndItemDetails(validUserObject.getUserDetailsPojo(), updateItem);
			    		 userItemsDealerMapperExists.setQuantity(userItemsDealerMapperExists.getQuantity()+item.getQuantity());
			    		 itemsDealerMapperRepository.saveAndFlush(userItemsDealerMapperExists);
					    }
					    
					    else
					    {
					    	 UserItemsDealerMapper dealerMapper = new UserItemsDealerMapper();
						     dealerMapper.setUserDetails(validUserObject.getUserDetailsPojo());
						     dealerMapper.setItemDetails(updateItem);
						     dealerMapper.setQuantity(item.getQuantity());						     
					    	 itemsDealerMapperRepository.saveAndFlush(dealerMapper);
					    }
			    
			     }
			     else
			     {
			    	 UserItemsDealerMapper dealerMapper = new UserItemsDealerMapper();
				     dealerMapper.setUserDetails(validUserObject.getUserDetailsPojo());
				     dealerMapper.setQuantity(item.getQuantity());			    	 
			    	 itemDetailsRepository.saveAndFlush(item);
			    	 entityManager.refresh(item);
			    	 updateItem = itemDetailsRepository.findByName(item.getName());
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
