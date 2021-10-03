<%@page import="oop.service.SchoolService"%>
<%@page import="oop.service.ISchoolService"%>
<%@page import="java.util.List"%>
<%@page import="oop.model.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
      <link rel = "stylesheet"
            type = "text/css"
            href = "bootstrap/css/bootstrap.min.css" />           
      <title>Teachers Information Management System</title>
   </head>
   <body>
      <div style="text-align:center">
            <h2 align="center">Teacher Details Management</h2>
	        <h3>	          
	            <a href="AddTeacherServlet?id= ">Add New Teacher</a>
	             &nbsp;&nbsp;&nbsp;     
	        </h3>
      </div>
      <div class="container">
        <h4 align="center">List of Teachers</h4>
        <table  class="table table-condensed table-responsive">          
            <tr class="danger">
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>               
                <th>Address</th>
                <th>Qualifications</th>
                <th>Gender</th>
                <th>Salary</th>
                <th>NIC</th>
                <th>Email</th>
            </tr>
             <%            
                String teacherID = (String)request.getAttribute("TeacherID");    
                ISchoolService iTeacherService = new SchoolService();
		    	List<Teacher> listOfTeachers = iTeacherService.getTeachers(teacherID);

                for(Teacher teacher : listOfTeachers){                	
			 %>
             <tr class="success">
                    <td> <%=teacher.getTeacherID() %> </td>
                    <td> <%=teacher.getFirstName() %> </td>
                    <td> <%=teacher.getLastName() %> </td>
                    <td> <%=teacher.getAddress() %> </td>
                    <td> <%=teacher.getQualifications() %> </td>
                    <td> <%=teacher.getGender() %> </td>
                    <td> <%=teacher.getSalary() %> </td>
                    <td> <%=teacher.getNic() %> </td>
                    <td> <%=teacher.getEmail() %> </td>
                    <td>
                        <a href="AddTeacherServlet?id=<%=teacher.getTeacherID()%>">Edit</a>       
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="DeleteTeacherServlet?id=<%=teacher.getTeacherID()%>" onclick="return confirm('Are you sure?')">Delete</a>                       
                    </td>                            
               </tr>
               <%	
			     }
               %>  
        </table>
        <br/>
        <br/>
        <div align="center">
	        <form method="POST" action="ListTeacherServlet" class="form-inline">
					<input type="Text" name="TeacherID" value="" class="form-control"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value= "Select Teacher" class="btn btn-info" /> 
			</form> 
		</div>
    </div> 
    <%--<%@ include file = "TeacherFooter.jsp" %> --%>
</body>
</html>