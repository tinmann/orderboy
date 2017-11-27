package com.starter.orderBoy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.JoinColumn;
 
@Entity
@Table(name = "USER_DETAILS")
public class UserDetailsPojo {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private long id;
 
 
    @NotBlank(message = "Please enter the First Name")
    @Valid
    @Column(name = "FIRST_NAME")
    private String firstName;
 
 
    @NotBlank(message = "Please enter the Last Name")
    @Valid
    @Column(name = "LAST_NAME")
    private String lastName;
 
 
    @NotBlank(message = "Please select the Type")
    @Valid
    @Column(name = "TYPE")
    private String type;
    
    @Column(name = "STATUS")
    private String status;
 
    @Valid
    @OneToOne(mappedBy="userDetailsPojo", cascade = CascadeType.ALL)
    private UserPojo userPojo;
    
 /*  @ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "USER_SHOP_ITEMS_MAPPER", 
        joinColumns = { @JoinColumn(name = "USER_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "ITEMS_ID") })
    private List<ItemDetails> itemsShop = new ArrayList<ItemDetails>();*/
    
    @OneToMany( mappedBy="userDetails")  
    private List<UserItemsShopMapper> userItemsShopMapper = new ArrayList<UserItemsShopMapper>();
    
    @OneToMany( mappedBy="userDetails")  
    private List<UserItemsCustomerMapper> userItemsCustomerMapper = new ArrayList<UserItemsCustomerMapper>();
   
   
   
   
   
   /*@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
   @JoinTable(name = "USER_CUSTOMER_ITEMS_MAPPER", 
       joinColumns = { @JoinColumn(name = "USER_ID") }, 
       inverseJoinColumns = { @JoinColumn(name = "ITEMS_ID") })
   private List<ItemDetails> itemsCustomer = new ArrayList<ItemDetails>();*/
     
    public UserDetailsPojo() {
 
    }
 
  
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
   
    public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public UserPojo getUserPojo() {
		return userPojo;
	}



	public void setUserPojo(UserPojo userPojo) {
		this.userPojo = userPojo;
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

	


	/*public List<ItemDetails> getItemsShop() {
		return itemsShop;
	}



	public void setItemsShop(List<ItemDetails> itemsShop) {
		this.itemsShop = itemsShop;
	}
	
	public List<ItemDetails> getItemsCustomer() {
		return itemsCustomer;
	}



	public void setItemsCustomer(List<ItemDetails> itemsCustomer) {
		this.itemsCustomer = itemsCustomer;
	}
	
	public void addItemRetailer(ItemDetails itemDetails) {
		itemsShop.add(itemDetails);
		itemDetails.getUserDetailsPojoRetailerList().add(this);
    }
 
    public void removeItemRetailer(ItemDetails itemDetails) {
    	itemDetails.getUserDetailsPojoRetailerList().remove(this);
    	itemsShop.remove(itemDetails);
    	
    }
    
    public void addItemCustomer(ItemDetails itemDetails) {
    	itemsCustomer.add(itemDetails);
		itemDetails.getUserDetailsPojoCustomerList().add(this);
    }
 
    public void removeItemCustomer(ItemDetails itemDetails) {
    	itemsCustomer.remove(itemDetails);
    	itemDetails.getUserDetailsPojoCustomerList().remove(this);
    }
*/


	/*@Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", section=" + section + ", address=" + address
                + "]";
    }*/
	
	
 
}
