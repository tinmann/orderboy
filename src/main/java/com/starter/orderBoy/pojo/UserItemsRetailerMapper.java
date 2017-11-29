package com.starter.orderBoy.pojo;

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
@Table(name = "USER_RETAILER_ITEMS_MAPPER")
public class UserItemsRetailerMapper {
	
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
	    
	    @Valid
	    @Column(name="UOM")
	    private String uom;
	    
	    @Valid
	    @Column(name="rate")
	    private double rate;
	    
	    @Valid
	    @Column(name="TOTAL_VALUE")
	    private double totalValue;
	    
	    @Valid
	    @Column(name="TOTAL_TAXABLE_VALUE")
	    private double totalTaxableValue;
	    
	    @Valid
	    @Column(name="TOTAL_GST")
	    private double totalGst;

	    @Valid
	    @Column(name="TOTAL_CGST")
	    private double totalCgst;
	    
	    @Valid
	    @Column(name="TOTAL_SGST")
	    private double totalSgst;
	    
	    @Valid
	    @Column(name="TOTAL_IGST")
	    private double totalIgst;

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

		public String getUom() {
			return uom;
		}

		public void setUom(String uom) {
			this.uom = uom;
		}

		public double getRate() {
			return rate;
		}

		public void setRate(double rate) {
			this.rate = rate;
		}

		public double getTotalValue() {
			return totalValue;
		}

		public void setTotalValue(double totalValue) {
			this.totalValue = totalValue;
		}

		public double getTotalTaxableValue() {
			return totalTaxableValue;
		}

		public void setTotalTaxableValue(double totalTaxableValue) {
			this.totalTaxableValue = totalTaxableValue;
		}

		public double getTotalGst() {
			return totalGst;
		}

		public void setTotalGst(double totalGst) {
			this.totalGst = totalGst;
		}

		public double getTotalCgst() {
			return totalCgst;
		}

		public void setTotalCgst(double totalCgst) {
			this.totalCgst = totalCgst;
		}

		public double getTotalSgst() {
			return totalSgst;
		}

		public void setTotalSgst(double totalSgst) {
			this.totalSgst = totalSgst;
		}

		public double getTotalIgst() {
			return totalIgst;
		}

		public void setTotalIgst(double totalIgst) {
			this.totalIgst = totalIgst;
		}
	    
	    

}
