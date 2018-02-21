package com.starter.orderBoy.pojo;

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
    
    @Valid
    @Column(name = "COMPANY_NAME")
    private String companyName;
 
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
    
    @Valid
    @Column(name = "OWNERSHIP_TYPE")
    private String ownershipType;
    
    @Column(name = "STATUS")
    private String status;
    
    @Valid 
    @Column(name="PHONE_LAND")
    private String phoneLand;
    
    @Valid
    @Column(name="PHONE_MOBILE")
    private String phoneMobile;
    
    @Valid
    @Column(name="GSTIN_NO")
    private String gstnNo;
    
    @Valid
    @Column(name="LICENCE_NO")
    private String licenceNo;
    
    @Valid
    @Column(name="CIN_NO")
    private String cinNo;
 
    @Valid
    @OneToOne(mappedBy="userDetailsPojo", cascade = CascadeType.ALL)
    private UserPojo userPojo;
    
    @Valid
    @OneToOne(mappedBy="userDetailsPojo", cascade = CascadeType.ALL)
    private AddressPojo address;
    
    @Valid
    @Column(name="EMAIL")
    private String email;
    
    
    
    
 /*  @ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "USER_SHOP_ITEMS_MAPPER", 
        joinColumns = { @JoinColumn(name = "USER_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "ITEMS_ID") })
    private List<ItemDetails> itemsShop = new ArrayList<ItemDetails>();*/
    
    @OneToMany( mappedBy="userDetails")  
    private List<UserItemsDealerMapper> userItemsDealerMapper = new ArrayList<UserItemsDealerMapper>();
    
    @OneToMany( mappedBy="userDetails")  
    private List<UserItemsRetailerMapper> userItemsRetailerMapper = new ArrayList<UserItemsRetailerMapper>();
   
   
   
   
   
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



	public AddressPojo getAddress() {
		return address;
	}



	public void setAddress(AddressPojo address) {
		this.address = address;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getOwnershipType() {
		return ownershipType;
	}



	public void setOwnershipType(String ownershipType) {
		this.ownershipType = ownershipType;
	}



	public String getPhoneLand() {
		return phoneLand;
	}



	public void setPhoneLand(String phoneLand) {
		this.phoneLand = phoneLand;
	}



	public String getPhoneMobile() {
		return phoneMobile;
	}



	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}



	public String getGstnNo() {
		return gstnNo;
	}



	public void setGstnNo(String gstnNo) {
		this.gstnNo = gstnNo;
	}



	public String getLicenceNo() {
		return licenceNo;
	}



	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}



	public String getCinNo() {
		return cinNo;
	}



	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	

 
}
