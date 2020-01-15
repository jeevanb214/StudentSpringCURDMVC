<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><!-- for form:form -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Students Info</title>
</head>
<body>
	<center>
		Fill the Student Details
																			<!-- here we are taking the student object which we got from the controller and we insert the values into it -->
		<form:form action="registerSuccess" method="post" modelAttribute="student"> <!--About  modelAttribute   https://stackoverflow.com/a/47207619 given very clearly it is very important to go through thsi  -->
			<table>
				<!-- <tr>
				<td>Id</td>
				<td><form:input path="id"/></td>
				</tr> -->

				<tr>
					<td>Name</td>
					<td><form:input path="sName" /></td> <!--  same name should be declared as in the model class -->
				</tr>

				<tr>
					<td>Age</td>
					<td><form:input path="age" /></td>
				</tr>

				<tr>
					<td>Gender</td>
					<td><form:input path="gender" /></td>
				</tr>

				<tr>

					<td>Dept</td>
					<td><form:input path="dept" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Register"></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>