package com.starter.orderBoy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "USER_SHOP_ITEMS_MAPPER")
public class UserItemsShopMapper {
	
	    @Id  
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name = "ID")
	    private Long id;  
	    
	    @ManyToOne
	    @JoinColumn(name = "USER_ID")
	    private UserDetailsPojo userDetails;  
	    
	    @ManyToOne 
	    @JoinColumn(name = "ITEMS_ID")
	    private ItemDetails itemDetails;
	    
	    @Valid
	    @Digits(integer=8,fraction=0)
	    @Column(name="QUANTITY")
	    private int quantity;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public UserDetailsPojo getUserDetails() {
			return userDetails;
		}

		public void setUserDetails(UserDetailsPojo userDetails) {
			this.userDetails = userDetails;
		}

		public ItemDetails getItemDetails() {
			return itemDetails;
		}

		public void setItemDetails(ItemDetails itemDetails) {
			this.itemDetails = itemDetails;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		
	    
	    
	      
	     

}
