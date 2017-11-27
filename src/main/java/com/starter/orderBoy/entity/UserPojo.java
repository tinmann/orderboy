package com.starter.orderBoy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.annotations.GenericGenerator;
 
 
@Entity
@Table(name = "USER_LOG")
public class UserPojo {
	
    @Valid
    @Id
    @Column(name="USER_ID")
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property", value="userDetailsPojo"))
    private long id;
    
    @NotBlank(message = "Please enter the User Id")
    @Valid
    @Column(name = "LOGIN_ID")
    private String loginId;
 
   
    @NotBlank(message = "Please enter the Password")
    @Valid
    @Column(name = "PASSWORD")
    private String password;
 
    @OneToOne
    @PrimaryKeyJoinColumn
    private UserDetailsPojo userDetailsPojo;
    
   /* @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_CUSTOMER_ITEMS_MAPPER", 
        joinColumns = { @JoinColumn(name = "USER_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "ITEMS_ID") })
    private List<ItemDetails> itemsCustomer = new ArrayList<ItemDetails>();*/
 
    public UserPojo() {
 
    }
 
    
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
   
    public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public UserDetailsPojo getUserDetailsPojo() {
		return userDetailsPojo;
	}



	public void setUserDetailsPojo(UserDetailsPojo userDetailsPojo) {
		this.userDetailsPojo = userDetailsPojo;
	}



	public String getLoginId() {
		return loginId;
	}



	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	



	/*public List<ItemDetails> getItemsCustomer() {
		return itemsCustomer;
	}



	public void setItemsCustomer(List<ItemDetails> itemsCustomer) {
		this.itemsCustomer = itemsCustomer;
	}*/

	


	/*@Override
    public String toString() {
        return "Address [id=" + id + ", street=" + street + ", city=" + city
                + ", country=" + country + "]";
    }*/
     
}
