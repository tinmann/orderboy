package com.starter.orderBoy.pojo;

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
@Table(name = "HSN_TABLE")
public class HsnTable {
	
	@Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
	
	 @Valid
	 @Column(name = "HSN_NUMBER")
	 private String hsnNumber;
	 
	 @Valid
	 @Column(name = "HSN_NAME")
	 private String hsnName;
	 
	 @Valid
	 @Column(name = "DESCRIPTION")
	 private String description;
	 
	 @OneToMany(mappedBy="hsnObject")  
	 private List<ItemDetails> itemsList = new ArrayList<ItemDetails>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHsnNumber() {
		return hsnNumber;
	}

	public void setHsnNumber(String hsnNumber) {
		this.hsnNumber = hsnNumber;
	}

	public String getHsnName() {
		return hsnName;
	}

	public void setHsnName(String hsnName) {
		this.hsnName = hsnName;
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
