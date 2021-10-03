<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Employee.css" />

<meta charset="UTF-8">
<title>SLIIT OOP Student Information Management</title>
</head>
<body class="body">

	<jsp:include page="/WEB-INF/Views/header.jsp"></jsp:include>

	<h2 class="h2">Add Teacher Page</h2>

	   SLIIT Student Information App for Object Orineted Progrmming
	<br>
	<br>

	<form method="POST" action="AddTeacherServlet">
		<table>

			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" /></td>
			</tr>			
			<tr>
				<td>Faculty</td>
				<td><input type="text" name="faculty" /></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><input type="text" name="department" /></td>
			</tr>
			<tr>
				<td>Qualifications</td>
				<td><input type="text" name="qualification" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male"
					checked="checked" tabindex="1" /> Male</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="gender" value="female"
					tabindex="2" /> Female</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Teacher" class="add-button" /> </td>
			</tr>
			<tr>	
				<td colspan="2"><input type="reset" value="Reset" class="reset-button" /></td>
			</tr>
		</table>
	</form>

	<form method="POST" action="ListTeacherServlet">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="List All Teachers" class="list-button" />
				</td>
			</tr>
		</table>
	</form>

	<jsp:include page="/WEB-INF/Views/footer.jsp"></jsp:include>

</body>
</html>