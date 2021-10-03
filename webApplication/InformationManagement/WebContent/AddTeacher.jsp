<%@page import="oop.model.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <link rel = "stylesheet"
            type = "text/css"
            href = "bootstrap/css/bootstrap.min.css" />
    <title>Student Information Management Application</title>
    <script type="text/javascript">  
        function validateFloatNumbers(){
        	var sal = document.addTeacher.salary.value;
        	return !isNaN(sal) && isFinite(sal);
        }
        
        function validateEmail() {
        	var em = document.addTeacher.email.value;
            var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return re.test(String(em).toLowerCase());
        }
        
        function validateForm(){
        	if(validateFloatNumbers() && validateEmail()){
        		return true;         		
        	}
        	else {
        		if(!validateFloatNumbers()){
        			alert('salary format is invalid');
        			return false;
        		}
        		
        		if(!validateEmail()){
        			alert("Email format is invalid");
        			return false;
        		}        		   
        	}        		
        }        
        
  </script>  
  </head>
  <body>
    <div style="text-align:center"><h2>Teacher Details Management</h2></div> 
    <h3 align="center">	          
           <a href="ListTeacherServlet" >List Teachers</a>   
	 </h3>     
	<div class="container">     
    <form action="AddTeacherServlet" method="post" class="form-horizontal" onSubmit="return validateForm()" name="addTeacher">         
      
               
	             <c:if test="${teacher != null}">
	                 <h3 align="center">Edit Teacher </h3> 
	              </c:if>
	              <c:if test="${teacher == null}">
	                 <h3 align="center"> Add New Teacher </h3>
	              </c:if>
      
	            <%
	              Teacher tc = new Teacher();
	              tc = (Teacher)request.getAttribute("teacher");           
		        %>  
	         <c:if test="${teacher != null}">
	           <input type="hidden" name="id" value="<c:if test="${tc != null}"><%=tc.getTeacherID() %> </c:if>" />
	         </c:if> 
                      
	         <div class="form-group">
                <label class="control-label col-sm-3">Teacher ID:</label>
                <div class="col-sm-7"> 
	                 <input type="text" name="teacherID"   required class="form-control"
	                   value="<c:if test="${teacher != null}"><%=tc.getTeacherID() %> </c:if>" placeholder="Enter Teacher ID"/>
	            </div>	                
	         </div>
             <div class="form-group">
                <label class="control-label col-sm-3">First Name:</label>
                <div class="col-sm-7"> 
	                 <input type="text" name="firstName"  required class="form-control"
	                   value="<c:if test="${teacher != null}"><%=tc.getFirstName() %> </c:if>" placeholder="Enter First Name"/>
	            </div>                
	         </div>
             <div class="form-group">
                <label class="control-label col-sm-3">Last Name:</label>
                <div class="col-sm-7">  
	                 <input type="text" name="lastName"   required  class="form-control"
	                   value="<c:if test="${teacher != null}"><%=tc.getLastName() %> </c:if>" placeholder="Enter Last Name"/>
	            </div>                
	         </div>       
            <div class="form-group">
                <label class="control-label col-sm-3">Address:</label>
                <div class="col-sm-7">                
	                 <input type="text" name="address"   required class="form-control"
	                   value="<c:if test="${teacher != null}"><%=tc.getAddress() %> </c:if>" placeholder="Enter Address"/>
	            </div>               
	        </div>
            <div class="form-group">
                <label class="control-label col-sm-3">Qualifications:</label>
                 <div class="col-sm-7"> 
	                 <input type="text" name="qualifications"   required class="form-control"
	                   value="<c:if test="${teacher != null}"><%=tc.getQualifications() %> </c:if>" placeholder="Enter Qualifications"/>
	             </div>                
	         </div>            
             <div class="form-group">
                <label class="control-label col-sm-3">Gender:</label>
                <div class="col-sm-7"> 
	                 <input type="text" name="gender"  required  class="form-control"
	                   value="<c:if test="${teacher != null}"><%=tc.getGender() %> </c:if>" placeholder="Enter Gender"/>
	            </div>                
	         </div>
             <div class="form-group">
                <label class="control-label col-sm-3">Salary:</label>
                <div class="col-sm-7"> 
	                 <input type="text" name="salary"   required class="form-control"
	                   value="<c:if test="${teacher != null}"><%=tc.getSalary() %> </c:if>" placeholder="Enter Salary"/>
	            </div>                
	         </div>
             <div class="form-group">
                <label class="control-label col-sm-3">NIC:</label>
                <div class="col-sm-7"> 
	                 <input type="text" name="nic"   required  class="form-control"
	                   value="<c:if test="${teacher != null}"><%=tc.getNic() %> </c:if>" placeholder="Enter NIC"/>
	            </div>                
	         </div>
	         <div class="form-group">
                <label class="control-label col-sm-3">Email:</label>
                <div class="col-sm-7"> 
	                 <input type="text" name="email"   required  class="form-control" aria-describedby="emailHelp" 
	                   value="<c:if test="${teacher != null}"><%=tc.getEmail() %> </c:if>" placeholder="Enter Email"/>
	                  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	            </div>                
	         </div> 
	         <div class="form-group">
                <label class="control-label col-sm-3"></label>
                <div class="col-sm-7"> 
	                <input type="submit" name="Upload" value="Upload Certificates" class="btn btn-info" width="200"/> 
	                <input type="submit" name="Save" value="Save" class="btn btn-primary" width="200"/> 
	            </div>                
	         </div> 
	                               
        </form>
     </div>
    <%--<%@ include file = "TeacherFooter.jsp" %> --%>
</body>
</html>