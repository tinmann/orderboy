package com.starter.orderBoy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.starter.orderBoy.entity.ItemCheckedListPojo;
import com.starter.orderBoy.entity.ItemCheckedPojo;
import com.starter.orderBoy.entity.SearchItems;
import com.starter.orderBoy.pojo.ItemDetails;
import com.starter.orderBoy.pojo.UserDetailsPojo;
import com.starter.orderBoy.pojo.UserItemsDealerMapper;
import com.starter.orderBoy.pojo.UserItemsRetailerMapper;
import com.starter.orderBoy.pojo.UserPojo;
import com.starter.orderBoy.service.UserService;



@Controller
public class UserController {
	
	@Autowired UserService userService;
	
	 @Autowired 
	 private HttpSession httpSession;
 
    @RequestMapping(value = "/userDetails", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("userHome", "userDetailsPojo", new UserDetailsPojo());
    }
    
    @RequestMapping(value="/editUserDetailsGet", method = RequestMethod.GET)
    public ModelAndView editUserDetailsGet(ModelMap model)
    {
    	 model.addAttribute("selectPage","editUserDetails");
    	 return new ModelAndView("admin/adminHome", "userDetailsPojo", userService.getUserDetailsToEdit(((UserPojo)httpSession.getAttribute("user")).getUserDetailsPojo().getId()));
    			 
    }
    
    @RequestMapping(value = "/editUserDetailsPost", method = RequestMethod.POST)
    public String editUserDetailsPost(@Valid @ModelAttribute("userDetailsPojo") UserDetailsPojo userDetailsPojo, 
    	      BindingResult result,ModelMap model) {
    	
    	if (result.hasErrors()) {
    		System.out.println("was here");
    		System.out.println(result.toString());
    		 model.addAttribute("selectPage","editUserDetails");
            return "admin/adminHome";
        }     
        try
        {
        	UserDetailsPojo userDetailsOriginal = ((UserPojo)httpSession.getAttribute("user")).getUserDetailsPojo();
        	userDetailsPojo.setId(userDetailsOriginal.getId());
        	userDetailsPojo.getAddress().setAddressId(userDetailsOriginal.getAddress().getAddressId());
        	userDetailsPojo.getUserPojo().setId(userDetailsOriginal.getUserPojo().getId());
        	userDetailsPojo.getUserPojo().setLoginId(userDetailsOriginal.getUserPojo().getLoginId());
        	 UserDetailsPojo userDetailsPojoNew =  userService.editUserDetailsUser(userDetailsPojo);      
             model.addAttribute("userDetailsObj",userDetailsPojoNew);
             model.addAttribute("firstName", userDetailsPojoNew.getFirstName());
             model.addAttribute("lastName", userDetailsPojoNew.getLastName());
             model.addAttribute("type", userDetailsPojoNew.getType());
             model.addAttribute("message", "Successfully Edited");
             model.addAttribute("selectPage","editUserSuccess");
             return "admin/adminHome";
            // return "editSuccessPage";
        }
    
        catch(Exception ex)
        {
        	 model.addAttribute("selectPage","editUserDetails");
             return "admin/adminHome";
        	
        }
    	
    }
  
    @RequestMapping(value = "/addUserDetails", method = {RequestMethod.GET,RequestMethod.POST})
    public String submit(@Valid @ModelAttribute("userDetailsPojo") UserDetailsPojo userDetailsPojo, 
      BindingResult result,ModelMap model) {
        if (result.hasErrors()) {
            return "userHome";
        }     
        try
        {
        UserDetailsPojo userDetailsPojoNew =  userService.registerUser(userDetailsPojo);      
        model.addAttribute("userObj",userDetailsPojoNew.getUserPojo());
        model.addAttribute("firstName", userDetailsPojoNew.getFirstName());
        model.addAttribute("lastName", userDetailsPojoNew.getLastName());
        model.addAttribute("type", userDetailsPojoNew.getType());
        model.addAttribute("password", userDetailsPojoNew.getUserPojo().getPassword());
        return "userDetailsView";
        }
        catch(Exception ex)
        {
        	return "userHome";
        }
    }
    
    @RequestMapping(value = "/loginUserForm", method = RequestMethod.GET)
    public ModelAndView showLoginForm() {
        return new ModelAndView("userLogin", "userPojo", new UserPojo());
    }
    
    @RequestMapping(value = "/forgetPassForm", method = RequestMethod.GET)
    public ModelAndView forgetPassForm() {
        return new ModelAndView("forgotPassword", "userPojo", new UserPojo());
    }
    
    @RequestMapping(value = "/loginUser", method = {RequestMethod.GET,RequestMethod.POST})
    public String loginUser(@Valid @ModelAttribute("userPojo") UserPojo userPojo, 
      BindingResult result,ModelMap model)
    {
        if (result.hasErrors()) {
            return "userLogin";
        }      
        
        try
        {
        UserPojo fetchedObject =  userService.loginUser(userPojo); 
        

        
        if(fetchedObject!=null)
        {
        	httpSession.setAttribute("user",fetchedObject); 
        	
        	//return "redirect:userProducts";
        	 return "redirect:addUserItemUpload";
        	
        	
        }
        else
        {
        	 model.addAttribute("errorMessage", "Incorrect Userid or Password");
        	return "userLogin";
        }
        }
        catch(Exception ex)
        {
        	model.addAttribute("errorMessage", "Incorrect Userid or Password");
        	return "userLogin";
        }
      
    }
    
   /* @RequestMapping(value = "/userProducts", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView userProducts(ModelMap model) {
    	
    	System.out.println("new reached");
    	
    	ItemCheckedListPojo itemCheckedListPojo = new ItemCheckedListPojo();
       
    	SearchItems searchItems = new SearchItems();
    	
    	try
    	{
    	
    	List<ItemCheckedPojo> formDeliverList = new ArrayList<ItemCheckedPojo>();
    	
    	List<ItemDetails> itemDetailsList = userService.getItemDetailsForDealer(searchItems);
    	
    	
    	UserPojo userObject= (UserPojo)httpSession.getAttribute("user");
    	
    	String userType = userObject.getUserDetailsPojo().getType();
    	
    	if(userType.equals("Dealer"))
    	{
    		List<UserItemsDealerMapper> previousItemsDealerMapperCheckList = userService.getPreviousItemDetailsForDealer();
        	
        	System.out.println(itemDetailsList);
        	
        	for (ItemDetails itemDetail : itemDetailsList) 
        	{
        		ItemCheckedPojo checkedPojoItem = new ItemCheckedPojo();
        		checkedPojoItem.setItemObj(itemDetail);
        		formDeliverList.add(checkedPojoItem);
        		
        		for (UserItemsDealerMapper previousItemsDealerMapperCheck : previousItemsDealerMapperCheckList) 
            	{
            	   if(itemDetail.getId() == previousItemsDealerMapperCheck.getItemDetails().getId())
            	   {
            		   checkedPojoItem.setChecked(1); 
            		   break;
            	   }
            	}
        		
        	}
        	
        	itemCheckedListPojo.setItemCheckedList(formDeliverList);
    	}
    	else if(userType.equals("Retailer"))
    	{
           List<UserItemsRetailerMapper> previousItemsRetailerMapperCheckList = userService.getPreviousItemDetailsForRetailer();       	
        	
        	for (ItemDetails itemDetail : itemDetailsList) 
        	{
        		ItemCheckedPojo checkedPojoItem = new ItemCheckedPojo();
        		checkedPojoItem.setItemObj(itemDetail);
        		formDeliverList.add(checkedPojoItem);
        		
        		for (UserItemsRetailerMapper previousItemsRetailerMapperCheck : previousItemsRetailerMapperCheckList) 
            	{
            	   if(itemDetail.getId() == previousItemsRetailerMapperCheck.getItemDetails().getId())
            	   {
            		   checkedPojoItem.setChecked(1); 
            		   break;
            	   }
            	}
        		
        	}
        	
        	itemCheckedListPojo.setItemCheckedList(formDeliverList);
    	}
    	
    	
    	
    	}
    	
    	catch(Exception ex)
    	{
    		return new ModelAndView("productPage", "itemCheckedListPojo", itemCheckedListPojo);
    	}
    
    	model.addAttribute("listItems", "listItems");
    	model.addAttribute("itemCheckedListPojo", "itemCheckedListPojo");
    	
    	return new ModelAndView("admin/adminHome", "itemCheckedListPojo", itemCheckedListPojo);
    	//return "admin/adminHome";
    	
      
    }*/
    
  /*  @RequestMapping(value = "/addUserItem", method = {RequestMethod.GET,RequestMethod.POST})
    public String addUserItem(@Valid @ModelAttribute("itemCheckedListPojo") ItemCheckedListPojo itemCheckedListPojo, 
      BindingResult result,ModelMap model)
    {
    	List<ItemCheckedPojo> testList = itemCheckedListPojo.getItemCheckedList();
    	for(ItemCheckedPojo it:testList)
    	{
   		System.out.println(it.getItemObj().getName());
    		System.out.println(it.getChecked());
    	}
    	
    	String success = userService.addUserItem(itemCheckedListPojo);
    	
    	
    	return "redirect:userProducts";
    }
    */
    @RequestMapping(value = "/logOutUser", method = RequestMethod.GET)
    public ModelAndView userLogOut() {    	
    	httpSession.invalidate();
        return new ModelAndView("userLogin", "userPojo", new UserPojo());
    }
    
    
    @GetMapping(value = "/mobileUserLoginForm")
   	public ResponseEntity<UserPojo> getMobileLoginForm() {
   		return new ResponseEntity<UserPojo>(new UserPojo(), HttpStatus.OK);
   	}
    
    @PostMapping(value = "/mobileUserLoginForm")
	public ResponseEntity<Void> getLoginDetails(@RequestBody UserPojo userPojo, UriComponentsBuilder builder,BindingResult result) {
               
                HttpHeaders headers = new HttpHeaders();
               
                if (result.hasErrors()) {
                	return new ResponseEntity<Void>(headers,HttpStatus.UNAUTHORIZED);
                }      
                
                try
                {
                UserPojo fetchedObject =  userService.loginUser(userPojo); 
                

                
                if(fetchedObject!=null)
                {
                	httpSession.setAttribute("user",fetchedObject); 
                	
                	
                	/// to change
                	return new ResponseEntity<Void>(headers,HttpStatus.OK);
                	//headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
                	
                	
                }
                else
                {
                	return new ResponseEntity<Void>(headers,HttpStatus.UNAUTHORIZED);
                }
                }
                catch(Exception ex)
                {
                	return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
                }
	}
    
    
    
    @GetMapping("/mobileUserRegForm")
	public ResponseEntity<UserDetailsPojo> getMobileRegForm() {
		return new ResponseEntity<UserDetailsPojo>(new UserDetailsPojo(), HttpStatus.OK);
	}
    
    
    
   /* logout
    
    HttpSession session=request.getSession();  
    session.invalidate();  
      
    out.print("You are successfully logged out!");  */
    
    
   /* checking validity
    
    HttpSession session=request.getSession(false);  
    if(session!=null){  
    String name=(String)session.getAttribute("name");  
      
    out.print("Hello, "+name+" Welcome to Profile");  
    }  
    else{  
        out.print("Please login first");  
        request.getRequestDispatcher("login.html").include(request, response);  
    }  */
    
    
   /* @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView loginUser(@Valid @ModelAttribute("userPojo") UserPojo userPojo, 
      BindingResult result,ModelMap model) {
        if (result.hasErrors()) {
            return "userLogin";
        }      
        UserPojo fetchedObject =  userService.loginUser(userPojo); 
        

        
        if(fetchedObject!=null)
        {
        	httpSession.setAttribute("user",fetchedObject); 
        	return new ModelAndView("productPage", "message", null);
        }
        else
        {
        	return new ModelAndView("userLogin", "userPojo", new UserPojo());
        }
      
    }*/
    
    // Very Very important link   https://stackoverflow.com/questions/5142065/jsr-303-valid-annotation-nested-object-not-working
    
    
    /// tial
    
}