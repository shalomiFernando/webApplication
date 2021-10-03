<%@page import="oop.model.Subject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <link rel = "stylesheet"
            type = "text/css"
            href = "bootstrap/css/bootstrap.min.css" />
    <title>Student Information Management Application</title>
  </head>
  <body>
    <div style="text-align:center"><h1>Subject Details Management</h1></div> 
    <h1 align="center">	          
           <a href="ListSubjectServlet" >List Subjects</a>   
	 </h1>     
    <div align="center">      
    <form action="AddSubjectServlet" method="post" class="form-horizontal">         
        <table border="1" cellpadding="5" class="table table-striped">
            <caption>           
	             <c:if test="${subject != null}">
	                 <h1 align="center">Edit Teacher </h1> 
	              </c:if>
	              <c:if test="${subject == null}">
	                 <h1 align="center"> Add New Teacher </h1>
	              </c:if>
            </caption>
	            <%
	              Subject tc = new Subject();
	              tc = (Subject)request.getAttribute("subject");           
		        %>  
	         <c:if test="${subject != null}">
	           <input type="hidden" name="id" value="<c:if test="${subject != null}"><%=tc.getSubjectID() %> </c:if>" />
	         </c:if> 
                      
	         <tr>
                <th>Subject ID: </th>
                <td>
                 <input type="text" name="subjectID" size="45" 
                   value="<c:if test="${subject != null}"><%=tc.getSubjectID() %> </c:if>"/>
                </td>
	         </tr>
             <tr>
                <th>Name: </th>
                <td>
                 <input type="text" name="name" size="45"
                   value="<c:if test="${subject != null}"><%=tc.getName() %> </c:if>" />
                </td>
             </tr>
             <tr>
                <th>Grade: </th>
                <td>
                 <input type="text" name="grade" size="45"
                   value="<c:if test="${subject != null}"><%=tc.getGrade() %> </c:if>" />
                </td>
             </tr>
             <tr>
                <th>Description: </th>
                <td>
                 <input type="text" name="description" size="45"
                   value="<c:if test="${subject != null}"><%=tc.getDescription() %> </c:if>" />
                </td>
             </tr>
           
                         
             <tr>
             <td colspan="2" align="center">
                <input type="submit" value="Save" class="btn btn-info" width="150px"/>
             </td>
            </tr>
        </table>
        </form>
    </div> 
    <%@ include file = "SubjectFooter.jsp" %>
</body>
</html>