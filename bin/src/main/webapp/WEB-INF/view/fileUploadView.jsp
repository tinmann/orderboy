<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="css/style.css" />
<h2>Submitted File</h2>
<table>
    <tr>
        <td>OriginalFileName:</td>
        <td>${editItemForm.fileName}</td>
    </tr>
    <tr>
        <td>Type:</td>
        <td>${editItemForm.fileType}</td>
    </tr>
</table>


<form:form method="POST" action="/addUserItemUpload" modelAttribute="editItemForm">
             <table align="center" >
             <tr>
             <th>Item HSN</th>
             <th>Item Name</th>
             <th>Item Quantity</th>
             </tr>
             
              <c:forEach items="${editItemForm.userItemsDealerMapperList}" var="itemDealerMapper" varStatus="gridRow">
                <tr>
                  
                    <td><form:input path="userItemsDealerMapperList[${gridRow.index}].itemDetails.hsnObject.hsnNumber" value="${itemDealerMapper.itemDetails.hsnObject.hsnNumber}" /></td>
                    
                     <td><form:input path="userItemsDealerMapperList[${gridRow.index}].itemDetails.name" value="${itemDealerMapper.itemDetails.name}" /></td>
                      <form:errors path="userItemsDealerMapperList[${gridRow.index}].itemDetails.name" style="color: red;"></form:errors>
                     
                     <td><form:input path="userItemsDealerMapperList[${gridRow.index}].quantity" value="${itemDealerMapper.quantity}" /></td>
                   
                  
                   
                </tr>
              </c:forEach>
                
            <form:hidden path="fileName" value ="${editItemForm.fileName}"/>
            <form:hidden path="fileType" value ="${editItemForm.fileType}"/>
                <tr>
                    <td></td>
                        <td align="left">
                        <input type="submit" value="Submit"/></td>
                </tr>
                <tr>
                <td></td>
                <td><a href="home.jsp">Home</a>
                        
                        </td>
                 </tr>
            </table>
            
            <a href="showUploadForm" class="nav-link"><i class="nc-icon nc-badge"></i>Upload New Items</a>
        </form:form>

</html>