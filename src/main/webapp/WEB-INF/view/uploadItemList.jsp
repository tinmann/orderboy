<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
<link rel="stylesheet" href="css/style.css" />
<form:form method="POST" action="/uploadItemFile" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label>Select a file to upload</label></td>
            <td> <input type="file" name="file" accept=".xls,.xlsx" /></td>
           
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>

</form:form>
</html>