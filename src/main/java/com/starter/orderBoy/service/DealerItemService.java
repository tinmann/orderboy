package com.starter.orderBoy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.starter.orderBoy.dao.DealerItemDao;
import com.starter.orderBoy.entity.ItemDealerListClass;
import com.starter.orderBoy.entity.ItemListClass;
import com.starter.orderBoy.pojo.ItemDetails;
import com.starter.orderBoy.pojo.UserItemsDealerMapper;

@Component
public class DealerItemService {

	@Autowired
	DealerItemDao dealerItemDao;
	
	
	public List<ItemDetails> ssnItemDetails(String hsnNumber)
	{
		return dealerItemDao.hsnItemDetails(hsnNumber);
	}
	public ItemDetails itemFetchDetails(int itemId)
	{
		return dealerItemDao.itemFetchDetails(itemId);
	}
	public List<UserItemsDealerMapper> itemUploadSave(ItemDealerListClass itemDealerListClass)
	{
		return dealerItemDao.itemUploadSave(itemDealerListClass);
	}
	public UserItemsDealerMapper getDealerMapperEditValues(int itemMapId)
	{
		return dealerItemDao.getDealerMapperEditValues(itemMapId);
	}
	
	public UserItemsDealerMapper saveEditDealerMapperValues(UserItemsDealerMapper editSingleItemForm)
	{
		return dealerItemDao.saveEditDealerMapperValues(editSingleItemForm);
	}
	
	public UserItemsDealerMapper getDealerMapperDeleteValues(int itemMapId)
	{
		return dealerItemDao.getDealerMapperEditValues(itemMapId);
	}
	
	public String deleteDealerMapperValues(int dealerMapperIdToDelete)
	{
		return dealerItemDao.deleteDealerMapperValues(dealerMapperIdToDelete);
	}
	
	
	
	
}
