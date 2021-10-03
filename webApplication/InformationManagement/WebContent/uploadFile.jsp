<%@page import="oop.model.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
   <link rel = "stylesheet"
            type = "text/css"
            href = "bootstrap/css/bootstrap.min.css" />
</head>  
  <body>
    <div style="text-align:center"><h2>Upload Files</h2></div> 
     
	<div class="container">     
    <form action="AddTeacherServlet" method="post" class="form-horizontal"  name="addTeacher">         
      
             <div class="container">
				  <form>
				    <div class="form-group">
				      <label for="comment">Document</label>
				      <textarea class="form-control" rows="8" id="comment"></textarea>
				    </div>
				  </form>
	        </div>
               
	         <div class="form-group">
                <label class="control-label col-sm-3"></label>
                <div class="col-sm-7"> 
	                <input type="submit" name="Upload" value="Browse Computer" class="btn btn-success" width="200"/> 
	                <input type="submit" name="Save" value="Save Changes" class="btn btn-primary" width="200"/> 
	            </div>                
	         </div> 
	                               
        </form>
     </div>
    <%--<%@ include file = "TeacherFooter.jsp" %> --%>
</body>
</html>