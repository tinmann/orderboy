<%@ page import = "com.starter.orderBoy.entity.UserPojo"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" href="css/style.css" />
<%
UserPojo userObject= (UserPojo)session.getAttribute("user");
%>

<p>

Hi <%= userObject.getUserDetailsPojo().getFirstName() %>
<br>
<a href="/logOutUser">LogOut</a>
</p>

 <form:form method="POST" action="/addUserItem" modelAttribute="itemCheckedListPojo">
             <table align="center" >
             <tr>
             <th>Item ID</th>
             <th>Item Name</th>
             <th>Item Price</th>
             <th>Check Item</th>
             </tr>
             
              <c:forEach items="${itemCheckedListPojo.itemCheckedList}" var="itemCheckedPojo" varStatus="gridRow">
                <tr>
                   <td> <c:out value="${itemCheckedPojo.itemObj.itemAutoId}"/></td>
                   <td><c:out value="${itemCheckedPojo.itemObj.name}"/></td>  
                   <td><c:out value="${itemCheckedPojo.itemObj.price}"/></td>  
                     <c:if test = "${itemCheckedPojo.checked == 1}">
                          <td><form:checkbox path="itemCheckedList[${gridRow.index}].checked" value="1" checked = "checked"/></td>
                     </c:if>
                     <c:if test = "${itemCheckedPojo.checked != 1 }">
                         <td><form:checkbox path="itemCheckedList[${gridRow.index}].checked" value="1"/></td>
                     </c:if>
                    
                   <form:hidden path="itemCheckedList[${gridRow.index}].itemObj.id" value ="${itemCheckedPojo.itemObj.id}"/>
                   <form:hidden path="itemCheckedList[${gridRow.index}].itemObj.name" value ="${itemCheckedPojo.itemObj.name}"/>
                
                </tr>
              </c:forEach>
                
                
               
                 
                
               <%--  <form:hidden path="userPojo.loginId" value ="1"/> --%>
                
              
                
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



<!-- <input type="checkbox" id="chkTest1" value="Sports" />Sports <br />
        <input type="checkbox" id="chkTest2" value="Entertainment" />Entertainment <br />
        <input type="checkbox" id="chkTest3" value="Travel" />Travel <br />
        <input type="checkbox" id="chkTest4" value="Home" />Home <br />
        <input type="checkbox" id="chkTest5" value="Test" />Test <br />
        <select id="lstTest" size="5">
        </select>
        <input type="button" id="btnTest" value="Test" /> -->



</html>
































