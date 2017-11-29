package com.starter.orderBoy.pojo;

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
    private List<UserItemsDealerMapper> userItemsDealerMapper = new ArrayList<UserItemsDealerMapper>();
    
    @OneToMany(mappedBy="itemDetails")  
    private List<UserItemsRetailerMapper> userItemsRetailerMapper = new ArrayList<UserItemsRetailerMapper>();  
     
    @ManyToOne
    @JoinColumn(name = "HSN_ID")
    private HsnTable hsnObject;
 
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
    
   

	public List<UserItemsDealerMapper> getUserItemsDealerMapper() {
		return userItemsDealerMapper;
	}

	public void setUserItemsDealerMapper(List<UserItemsDealerMapper> userItemsDealerMapper) {
		this.userItemsDealerMapper = userItemsDealerMapper;
	}

	public List<UserItemsRetailerMapper> getUserItemsRetailerMapper() {
		return userItemsRetailerMapper;
	}

	public void setUserItemsRetailerMapper(List<UserItemsRetailerMapper> userItemsRetailerMapper) {
		this.userItemsRetailerMapper = userItemsRetailerMapper;
	}

	public HsnTable getHsnObject() {
		return hsnObject;
	}

	public void setHsnObject(HsnTable hsnObject) {
		this.hsnObject = hsnObject;
	}

	@Override
    public String toString() {
        return "Subject [id=" + id + ", name=" + name + "]";
    }
	

}
