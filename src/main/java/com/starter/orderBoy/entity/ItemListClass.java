package com.starter.orderBoy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.starter.orderBoy.pojo.ItemDetails;

public class ItemListClass {
	
	@Valid
	private List<ItemDetails> itemDetailsListConfirm = new ArrayList<ItemDetails>();
	
	private String fileName;
	private String fileType;
	
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public List<ItemDetails> getItemDetailsListConfirm() {
		return itemDetailsListConfirm;
	}

	public void setItemDetailsListConfirm(List<ItemDetails> itemDetailsListConfirm) {
		this.itemDetailsListConfirm = itemDetailsListConfirm;
	}
	
	

}
