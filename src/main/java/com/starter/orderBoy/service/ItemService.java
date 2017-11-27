package com.starter.orderBoy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.starter.orderBoy.dao.ItemDao;
import com.starter.orderBoy.entity.ItemDetails;
import com.starter.orderBoy.entity.ItemListClass;
import com.starter.orderBoy.entity.UserItemsCustomerMapper;
import com.starter.orderBoy.entity.UserItemsShopMapper;

@Component
public class ItemService {
	
	@Autowired
	ItemDao itemDao;
	
	
	public List<ItemDetails> ssnItemDetails(String ssnNumber)
	{
		return itemDao.ssnItemDetails(ssnNumber);
	}
	public ItemDetails itemFetchDetails(int itemId)
	{
		return itemDao.itemFetchDetails(itemId);
	}
	public List<UserItemsShopMapper> itemUploadSave(ItemListClass itemListClass)
	{
		return itemDao.itemUploadSave(itemListClass);
	}
	public UserItemsShopMapper getShopMapperEditValues(int itemMapId)
	{
		return itemDao.getShopMapperEditValues(itemMapId);
	}
	
	public UserItemsShopMapper saveEditShopMapperValues(UserItemsShopMapper editSingleItemForm)
	{
		return itemDao.saveEditShopMapperValues(editSingleItemForm);
	}
	
	public UserItemsShopMapper getShopMapperDeleteValues(int itemMapId)
	{
		return itemDao.getShopMapperEditValues(itemMapId);
	}
	
	public String deleteShopMapperValues(int shopMapperIdToDelete)
	{
		return itemDao.deleteShopMapperValues(shopMapperIdToDelete);
	}
	
	
	
	

}
