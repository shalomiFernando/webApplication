<%@page import="oop.service.SchoolService"%>
<%@page import="oop.service.ISchoolService"%>
<%@page import="java.util.List"%>
<%@page import="oop.model.Event"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
      <link rel = "stylesheet"
            type = "text/css"
            href = "bootstrap/css/bootstrap.min.css" />
      <title>Student Information Management System</title>
   </head>
<body>
   <div style="text-align:center">
      <h1 align="center">Event Details Management</h1>
	        <h2>	          
	            <a href="AddEventServlet?id= " align="center">Add New Event</a>
	             &nbsp;&nbsp;&nbsp;     
	        </h2>
    </div>
    <div align="center">
        <h2 align="center">List of Events</h2>
        <table border="1" cellpadding="5" class="table table-striped">          
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Location</th>
                <th>Budget</th>
            </tr>
             <%            
                String eventID = (String)request.getAttribute("EventID");    
                ISchoolService iEventService = new SchoolService();
		    	List<Event> listOfEvents = iEventService.getEvents(eventID);
		    	
                for(Event event : listOfEvents){                	
			 %>
                <tr>
                    <td> <%=event.getEventID() %> </td>
                    <td> <%=event.getName() %> </td>
                    <td> <%=event.getDescription() %> </td>
                    <td> <%=event.getLocation() %> </td>
                    <td> <%=event.getBudget() %> </td>
                    <td>
                        <a href="AddEventServlet?id=<%=event.getEventID()%>">Edit</a>       
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="DeleteEventServlet?id=<%=event.getEventID()%>">Delete</a>                       
                    </td>                            
                </tr>
            <%
                }
            %> 
        </table>
        <br/>
        <br/>
        <div align="center">
	        <form method="POST" action="ListEventServlet" class="form-inline">
					<input type="Text" name="EventID" value="" class="form-control"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value= "Select Event" class="btn btn-info" /> 
			</form> 
		</div>
    </div> 
    <%@ include file = "EventFooter.jsp" %>
</body>
</html>