<%@page import="oop.service.SchoolService"%>
<%@page import="oop.service.ISchoolService"%>
<%@page import="java.util.List"%>
<%@page import="oop.model.Subject"%>
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
      <h1 align="center">Subject Details Management</h1>
	        <h2>	          
	            <a href="AddSubjectServlet?id= ">Add New Subject</a>
	             &nbsp;&nbsp;&nbsp;     
	        </h2>
    </div>
    <div align="center">
        <h2 align="center">List of Subjects</h2>
        <table border="1" class="table table-striped">          
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Grade</th>
                <th>Description</th>
            </tr>
             <%            
                String subjectID = (String)request.getAttribute("SubjectID");    
                ISchoolService iSubjectService = new SchoolService();
		    	List<Subject> listOfSubjects = iSubjectService.getSubjects(subjectID);
		    	
                for(Subject sub : listOfSubjects){                	
			 %>
                <tr>
                    <td> <%=sub.getSubjectID() %> </td>
                    <td> <%=sub.getName() %> </td>
                    <td> <%=sub.getGrade() %> </td>
                    <td> <%=sub.getDescription() %> </td>
                    <td>
                        <a href="AddSubjectServlet?id=<%=sub.getSubjectID()%>">Edit</a>       
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="DeleteSubjectServlet?id=<%=sub.getSubjectID()%>" id="deleteLink">Delete</a>                       
                    </td>                            
                </tr>
            <%
                }
            %> 
        </table>
        <br/>
        <br/>
        <div align="center">
	        <form method="POST" action="ListSubjectServlet" class="form-inline">
					<input type="Text" name="SubjectID" value="" class="form-control"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value= "Select Student" class="btn btn-info" /> 
			</form> 
		</div>
    </div> 
    <%@ include file = "SubjectFooter.jsp" %>
</body>
</html>