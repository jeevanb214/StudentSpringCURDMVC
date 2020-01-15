<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%><!-- this(isELIgnored="false") is very much important because to not get the errors as we entered the java code in the view page -->
	

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><!-- for form:form -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  <!--  by using this tag we can use some basic programming uses like c:out, c:if, c:forEach etc --> -->
<center>
	<h1>Students List</h1>
	<form action="updateOrDelete" method="post"> <!--  here we use the post because we are sending the radio button value -->
		<table border="5" cellpadding='8'>
			<tr>
				<th>Select</th>
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Dept</th>
			</tr>
			<c:forEach var="stud" items="${list}">
				<tr>


					<td><input type="radio" name="key" value="${stud.id}"></td>
					<td>${stud.id}</td>
					<td>${stud.sName}</td>
					<td>${stud.age}</td>
					<td>${stud.gender}</td>
					<td>${stud.dept}</td>

				</tr>
			</c:forEach>
		</table>
		<input type="submit" name="action" value="update"> 
		<input type="submit" name="action" value="delete"> <br/>
		<!-- <form action = "updateStudent">
   <input type = "submit" value = "update">
    <form action = "deleteStudent">
   <input type = "submit" value = "delete"> -->

		<a href="RegisterStudent">Add New Student</a>
</center>