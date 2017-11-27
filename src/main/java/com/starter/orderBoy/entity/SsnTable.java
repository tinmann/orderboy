package com.starter.orderBoy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name = "SSN_TABLE")
public class SsnTable {
	
	@Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
	
	 @Valid
	 @Column(name = "SSN_NUMBER")
	 private String ssnNumber;
	 
	 @Valid
	 @Column(name = "SSN_NAME")
	 private String ssnName;
	 
	 @Valid
	 @Column(name = "DESCRIPTION")
	 private String description;
	 
	 @OneToMany(mappedBy="ssnObject")  
	 private List<ItemDetails> itemsList = new ArrayList<ItemDetails>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSsnNumber() {
		return ssnNumber;
	}

	public void setSsnNumber(String ssnNumber) {
		this.ssnNumber = ssnNumber;
	}

	public String getSsnName() {
		return ssnName;
	}

	public void setSsnName(String ssnName) {
		this.ssnName = ssnName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ItemDetails> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemDetails> itemsList) {
		this.itemsList = itemsList;
	}
	 
	 
	    
	

}
