<%@page import="oop.model.Event"%>
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
    <div style="text-align:center"><h1>Event Details Management</h1></div> 
    <h1 align="center">	          
           <a href="ListEventServlet" >List Events</a>   
	 </h1>     
    <div align="center">      
    <form action="AddEventServlet" method="post" class="form-horizontal">         
        <table border="1" cellpadding="5" class="table table-striped">
            <caption>           
	             <c:if test="${event != null}">
	                 <h1 align="center">Edit Event </h1> 
	              </c:if>
	              <c:if test="${event == null}">
	                 <h1 align="center"> Add New Event </h1>
	              </c:if>
            </caption>
	            <%
	              Event ev = new Event();
	              ev = (Event)request.getAttribute("event");           
		        %>  
	         <c:if test="${event != null}">
	           <input type="hidden" name="id" value="<c:if test="${event != null}"><%=ev.getEventID() %> </c:if>" />
	         </c:if> 
                      
	         <tr>
                <th>Event ID: </th>
                <td>
                 <input type="text" name="eventID" size="45" 
                   value="<c:if test="${event != null}"><%=ev.getEventID() %> </c:if>"/>
                </td>
	         </tr>
             <tr>
                <th>Name: </th>
                <td>
                 <input type="text" name="name" size="45"
                   value="<c:if test="${event != null}"><%=ev.getName() %> </c:if>" />
                </td>
             </tr>
             <tr>
                <th>Description: </th>
                <td>
                 <input type="text" name="description" size="45"
                   value="<c:if test="${event != null}"><%=ev.getDescription() %> </c:if>" />
                </td>
             </tr>
             <tr>
                <th>Location: </th>
                <td>
                 <input type="text" name="location" size="45"
                   value="<c:if test="${event != null}"><%=ev.getLocation() %> </c:if>" />
                </td>
             </tr>
             <tr>
                <th>Budget: </th>
                <td>
                 <input type="text" name="budget" size="45"
                   value="<c:if test="${event != null}"><%=ev.getBudget() %> </c:if>" />
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
    <%@ include file = "TeacherFooter.jsp" %>
</body>
</html>