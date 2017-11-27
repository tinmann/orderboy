package com.starter.orderBoy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "ITEMS_TABLE")
public class ItemDetails {
	
	@Id
    @GeneratedValue
    @Column(name = "ITEMS_ID")
    private long id;
	
	//@NotBlank(message = "Please enter the User Id")
    @Valid
    @Column(name = "Item_auto_id")
    private String itemAutoId;
 
    @NotBlank(message = "Please enter the Item Name")
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "QUANTITY")
    private int quantity;
    
    @Column(name = "PRICE")
    private float price;
    
    
    @OneToMany(mappedBy="itemDetails")  
    private List<UserItemsShopMapper> userItemsShopMapper = new ArrayList<UserItemsShopMapper>();
    
    @OneToMany(mappedBy="itemDetails")  
    private List<UserItemsCustomerMapper> userItemsCustomerMapper = new ArrayList<UserItemsCustomerMapper>();  
     
    @ManyToOne
    @JoinColumn(name = "SSN_ID")
    private SsnTable ssnObject;
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
    
 
    public String getItemAutoId() {
		return itemAutoId;
	}

	public void setItemAutoId(String itemAutoId) {
		this.itemAutoId = itemAutoId;
	}

	public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
 
   
 
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
    
   

	
	
	public List<UserItemsShopMapper> getUserItemsShopMapper() {
		return userItemsShopMapper;
	}

	public void setUserItemsShopMapper(List<UserItemsShopMapper> userItemsShopMapper) {
		this.userItemsShopMapper = userItemsShopMapper;
	}
	
	public void removeUserItemsShopMapper(UserItemsShopMapper userItemsShopMapperObj) {
    	this.userItemsShopMapper.remove(userItemsShopMapperObj);
    	
    }

	public List<UserItemsCustomerMapper> getUserItemsCustomerMapper() {
		return userItemsCustomerMapper;
	}

	public void setUserItemsCustomerMapper(List<UserItemsCustomerMapper> userItemsCustomerMapper) {
		this.userItemsCustomerMapper = userItemsCustomerMapper;
	}

	
	public SsnTable getSsnObject() {
		return ssnObject;
	}

	public void setSsnObject(SsnTable ssnObject) {
		this.ssnObject = ssnObject;
	}

	@Override
    public String toString() {
        return "Subject [id=" + id + ", name=" + name + "]";
    }
	

}
