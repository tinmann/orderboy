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
             
              <c:forEach items="${editItemForm.itemDetailsListConfirm}" var="itemDetail" varStatus="gridRow">
                <tr>
                  
                    <td><form:input path="itemDetailsListConfirm[${gridRow.index}].ssnObject.ssnNumber" value="${itemDetail.ssnObject.ssnNumber}" /></td>
                    
                     <td><form:input path="itemDetailsListConfirm[${gridRow.index}].name" value="${itemDetail.name}" /></td>
                      <form:errors path="itemDetailsListConfirm[${gridRow.index}].name" style="color: red;"></form:errors>
                     
                     <td><form:input path="itemDetailsListConfirm[${gridRow.index}].quantity" value="${itemDetail.quantity}" /></td>
                   
                  
                   
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
        </form:form>

</html>