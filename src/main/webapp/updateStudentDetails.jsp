<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
Update Details

 <form:form action = "updateStudent" method="post" modelAttribute="student"> //here we will get the data from this object 
  <table>

        
			<!-- <tr>
				<td>Id</td>
				<td><form:input path="id"/></td>
			</tr> -->
			<input type = "hidden" name = "id" value = "${student.id}"/>
			<tr>
				<td>Name</td>
				<td><form:input path="sName" value="${student.sName}"/></td>
			</tr>


			<tr>
				<td>Age</td>
				<td><form:input path="age" value="${student.age}"/></td>
			</tr>
			
			<tr>
				<td>Gender</td>
				<td><form:input path="gender" value="${student.gender}"/></td>
            </tr>

			<tr>
			
				<td>Dept</td>
				<td><form:input path="dept" value="${student.dept}"/></td>
            </tr>

			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
    </table>
  </form:form>
</center>
</body>
</html>