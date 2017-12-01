package com.starter.orderBoy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.starter.orderBoy.service.DealerItemService;

@Controller
public class RetailerItemController {

	@Autowired 
	DealerItemService dealerItemService;
	
    @Autowired 
	private HttpSession httpSession;
}
