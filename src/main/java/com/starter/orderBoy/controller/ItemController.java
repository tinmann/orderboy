package com.starter.orderBoy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.starter.orderBoy.entity.ItemCheckedListPojo;
import com.starter.orderBoy.entity.ItemCheckedPojo;
import com.starter.orderBoy.entity.ItemDetails;
import com.starter.orderBoy.entity.ItemListClass;
import com.starter.orderBoy.entity.MyCell;
import com.starter.orderBoy.entity.SearchItems;
import com.starter.orderBoy.entity.SsnTable;
import com.starter.orderBoy.entity.UserDetailsPojo;
import com.starter.orderBoy.entity.UserItemsCustomerMapper;
import com.starter.orderBoy.entity.UserItemsShopMapper;
import com.starter.orderBoy.entity.UserPojo;
import com.starter.orderBoy.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired 
	ItemService itemService;
	
    @Autowired 
	private HttpSession httpSession;
    
    @RequestMapping(value = "/ssnItemList", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody List<ItemDetails> ssnItemList(@RequestParam("ssnNumber") String ssnNumber)
    {
    	List<ItemDetails> returnedList = itemService.ssnItemDetails(ssnNumber);

    	return returnedList;
    }
    
    @RequestMapping(value = "/itemFetchDetails", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody ItemDetails itemFetchDetails(@RequestParam("itemId") int itemId)
    {
    	ItemDetails itemDetails = itemService.itemFetchDetails(itemId);

    	return itemDetails;
    }
    
    @RequestMapping(value = "/showUploadForm", method = RequestMethod.GET)
    public String showUploadForm() {
        return "uploadItemList";
       
        
    }
    
    @RequestMapping(value = "/uploadItemFile", method = {RequestMethod.GET,RequestMethod.POST})
    public String submitUploadFile(@RequestParam("file") MultipartFile file, ModelMap modelMap,RedirectAttributes redirectAttributes) throws IOException{
      
        String fileLocation = file.getOriginalFilename();
        
        ItemListClass itemListClass = new ItemListClass();
        
        List<ItemDetails> itemDetailsListUpload = new ArrayList<ItemDetails>();
        
        
        if (fileLocation != null) {
        	if(fileLocation.endsWith(".xls"))
            {
        		File convFile = new File(file.getOriginalFilename());
                convFile.createNewFile(); 
                FileOutputStream fos = new FileOutputStream(convFile); 
                fos.write(file.getBytes());
                fos.close(); 
                
                InputStream targetStream = FileUtils.openInputStream(convFile);
                
        		HSSFWorkbook wb = new HSSFWorkbook(targetStream);

        		HSSFSheet sheet=wb.getSheetAt(0);
        		HSSFRow row; 
        		HSSFCell cell;

        		Iterator rows = sheet.rowIterator();

        		while (rows.hasNext())
        		{
        			row=(HSSFRow) rows.next();
        			Iterator cells = row.cellIterator();
        			
        			while (cells.hasNext())
        			{
        				cell=(HSSFCell) cells.next();
        		
        				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
        				{
        					System.out.print(cell.getStringCellValue()+" ");
        				}
        				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
        				{
        					System.out.print(cell.getNumericCellValue()+" ");
        				}
        				else
        				{
        					//U Can Handel Boolean, Formula, Errors
        				}
        			}
        			System.out.println();
        		}
            } 
            else if (fileLocation.endsWith(".xlsx"))
            {
            	System.out.println("XLSX");
            	File convFile = new File(file.getOriginalFilename());
                convFile.createNewFile(); 
                FileOutputStream fos = new FileOutputStream(convFile); 
                fos.write(file.getBytes());
                fos.close(); 
                
                InputStream targetStream = FileUtils.openInputStream(convFile);
               
                XSSFWorkbook  wb = new XSSFWorkbook(targetStream);
        		
        	//	XSSFWorkbook test = new XSSFWorkbook(); 
        		
        		XSSFSheet sheet = wb.getSheetAt(0);
        		XSSFRow row; 
        		XSSFCell cell;

        		Iterator rows = sheet.rowIterator();

        		while (rows.hasNext())
        		{
        			
        			
        			
        			row=(XSSFRow) rows.next();
        			
        			if(row.getRowNum()==0 || row.getRowNum()==1){
     			       continue; //just skip the rows if row number is 0 or 1
     			      }
        			
        			
        		    if (row.getLastCellNum() <= 0) {
        		        break;
        		    }
        			Iterator cells = row.cellIterator();
        			
        			ItemDetails itemDetailNew = new ItemDetails();
        			
        			int count = 1;
        			
        			
        			while (cells.hasNext())
        			{
        			
        				
        				StringBuilder stringValue = new StringBuilder();
        				
        				int intValue = 0;
        				
        				cell=(XSSFCell) cells.next();
        		
        				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
        				{
        					System.out.print(cell.getStringCellValue()+" ");
        					
        					stringValue.setLength(0);
        					stringValue.append(cell.getStringCellValue());
        					
        					
        				}
        				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
        				{
        					System.out.print(cell.getNumericCellValue()+" ");
        					intValue = (int) cell.getNumericCellValue();
        				}
        				else
        				{
        					//U Can Handel Boolean, Formula, Errors
        				}
        				
        				if(count == 1)
        				{
        					if(stringValue.length() != 0)
        					{
        						SsnTable hsnTable = new SsnTable();
        						hsnTable.setSsnNumber(stringValue.toString());
        						itemDetailNew.setSsnObject(hsnTable);
        						
        					}
        					else if(intValue!=0)
        					{
        						SsnTable hsnTable = new SsnTable();
        						hsnTable.setSsnNumber(Integer.toString(intValue));
        						itemDetailNew.setSsnObject(hsnTable);
        						

        					}
        					
        				}
        				else if(count == 2)
        				{
        					if(stringValue.length() == 0)
        					{
        						itemDetailNew.setName(null);
        					}
        					else
        					{
        						itemDetailNew.setName(stringValue.toString());
        					}
        					
        				}
        				else if(count == 3)
        				{
        					itemDetailNew.setDescription(stringValue.toString());
        				}
        				else if(count == 4 &&  intValue!=0)
        				{
        					itemDetailNew.setQuantity(intValue);
        				}
        				else if(count == 5)
        				{
        					itemDetailNew.setPrice(intValue);
        				}
        				else if(count == 6)
        				{
        					
        				}
        				else if(count == 7)
        				{
        					
        				}
        				else if(count == 8)
        				{
        					
        				}
        				else if(count == 9)
        				{
        					
        				}
        				else if(count == 10)
        				{
        					
        				}
        				else if(count == 11)
        				{
        					
        				}
        				
        				
        				count++;
        			}
        			System.out.println();
        			
        			if(itemDetailNew.getName()!=null && itemDetailNew.getName()!="" && itemDetailNew.getName()!=" ")
        			{
        				System.out.println("add");
        				itemDetailsListUpload.add(itemDetailNew);
        			}
        			
        			
        		}
                
            }
        } 
        else 
        {
           // model.addAttribute("message", "File missing! Please upload an excel file.");
        }
        
        itemListClass.setItemDetailsListConfirm(itemDetailsListUpload);
        itemListClass.setFileName(file.getOriginalFilename());
        itemListClass.setFileType(file.getContentType());
       
      //  modelMap.addAttribute("editItemForm", itemListClass);
    //    modelMap.addAttribute("file", file);
        
        //return new ModelAndView("redirect:fileUploadViewRoot", "file", file);
        
       // return "redirect:fileUploadViewRoot";
        
        redirectAttributes.addFlashAttribute("editItemForm", itemListClass);
        return "redirect:fileUploadViewRoot";
        
      //  return "fileUploadView";
        
    }
    
    @RequestMapping(value = "/fileUploadViewRoot", method = RequestMethod.GET)
    public String fileUploadViewGet(@Valid @ModelAttribute("editItemForm") ItemListClass itemListClass, 
  	      BindingResult result,ModelMap model) {
    	 // return "redirect:addUserItemUpload";
    	return "fileUploadView";
    	
    }
    
  
    
    @RequestMapping(value = "/fileUploadViewRoot", method = RequestMethod.POST)
    public String fileUploadView(@Valid @ModelAttribute("editItemForm") ItemListClass itemListClass, 
    	      BindingResult result,ModelMap model) {
    	
    	 
    	return "redirect:addUserItemUpload";
    	
      
    }
    
    @RequestMapping(value = "/addUserItemUpload", method = {RequestMethod.GET,RequestMethod.POST})
    public String loginUser(@Valid @ModelAttribute("editItemForm") ItemListClass itemListClass, 
      BindingResult result,ModelMap model)
    {
        if (result.hasErrors()) {
        	System.out.println("not valid");
            return "fileUploadView";
        }    
        
        List<UserItemsShopMapper> itemDetailsMappedObj = itemService.itemUploadSave(itemListClass);
        
        model.addAttribute("itemDetailsMappedObj", itemDetailsMappedObj);
        
        System.out.println("valid");
        System.out.println(itemListClass);
        
        
        
        return "yourItemList";
    }
    
    // ResponseEntity
    
    @RequestMapping(value="/editSingleMapItem",method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView getShopMapperEditValues(@Valid @ModelAttribute("editSingleItemForm") UserItemsShopMapper userItemsShopMapper, 
    	      BindingResult result,@RequestParam("itemMapId") int itemMapId,ModelMap model)
    {
    	UserItemsShopMapper shopMapperObjectToEdit = itemService.getShopMapperEditValues(itemMapId);
    	
    	model.addAttribute("shopMapperObjectToEdit", shopMapperObjectToEdit);
    	
    	System.out.println(shopMapperObjectToEdit.getItemDetails().getItemAutoId());
    	
    	return new ModelAndView("shopMapperEditPage", "editSingleItemForm", new UserItemsShopMapper());
    	
    	
    }
    
    @RequestMapping(value = "/editSubmit", method = {RequestMethod.GET,RequestMethod.POST})
    public String saveEditShopMapperValues(@Valid @ModelAttribute("editSingleItemForm") UserItemsShopMapper editSingleItemForm, 
      BindingResult result,ModelMap model)
    {
        if (result.hasErrors()) {
            return "errorPage";
        }  
        else
        {
        	UserItemsShopMapper shopMapperReturned = itemService.saveEditShopMapperValues(editSingleItemForm);
        	return "redirect:addUserItemUpload";
        }
    }
    
    @RequestMapping(value="/deleteSingleMapItem",method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView getShopMapperDeleteValues(@Valid @ModelAttribute("deleteSingleItemForm") UserItemsShopMapper userItemsShopMapper, 
    	      BindingResult result,@RequestParam("itemMapId") int itemMapId,ModelMap model)
    {
    	UserItemsShopMapper shopMapperObjectToDelete = itemService.getShopMapperDeleteValues(itemMapId);
    	
    	model.addAttribute("shopMapperObjectToDelete", shopMapperObjectToDelete);
    	
    	//System.out.println(shopMapperObjectToEdit.getItemDetails().getItemAutoId());
    	
    	return new ModelAndView("deleteConfirmBox", "deleteSingleItemConfirm", new UserItemsShopMapper());
    	
    	
    }
    
    
    @RequestMapping(value = "/deleteSingleMapItemConfirmed", method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteShopMapperValues(@RequestParam("itemMapId") int shopMapperIdToDelete)
    {
       
        	String resultStatus = itemService.deleteShopMapperValues(shopMapperIdToDelete);
        	return "successDeletion";
       
    }
    
    
    
  

}