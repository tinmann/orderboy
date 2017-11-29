package com.starter.orderBoy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.starter.orderBoy.pojo.UserItemsDealerMapper;



public class ItemDealerListClass {
	
	@Valid
	private List<UserItemsDealerMapper> userItemsDealerMapperList = new ArrayList<UserItemsDealerMapper>();
	
	private String fileName;
	private String fileType;
	public List<UserItemsDealerMapper> getUserItemsDealerMapperList() {
		return userItemsDealerMapperList;
	}
	public void setUserItemsDealerMapperList(List<UserItemsDealerMapper> userItemsDealerMapperList) {
		this.userItemsDealerMapperList = userItemsDealerMapperList;
	}
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
	
	

}
