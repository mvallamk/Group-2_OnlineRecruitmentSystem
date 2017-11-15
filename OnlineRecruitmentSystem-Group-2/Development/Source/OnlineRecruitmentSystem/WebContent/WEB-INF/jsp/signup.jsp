<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
a { font-size:30px; }
a.two:link {color:#004BAA;}
a.two:hover {font-size:150%;}
</style>
</head>
<body background="images/bg1.jpg">
	<h1 style="text-align:center">Create Account</h1>
	<p align="center" style="color: Red">${message}</p>
	<form:form action="checksignup.htm" method="post"
		modelAttribute="login">
		<table bgcolor="#E4E47C" align="center">
			<tr>
				<td>Signup as</td>
				<td><form:select path="type">
						<form:option value="" label="Please Select" />
						<form:options items="${users}" />
					</form:select></td>
				<td style="color: RED"><form:errors path="type" /></td>
			</tr>
			<tr>
				<td>UserName:</td>
				<td><form:input path="loginId" /></td>
				<td style="color: RED"><form:errors path="loginId" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
				<td style="color: RED"><form:errors path="password" /> <br /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="SignUp"></td>
			</tr>
		</table>
	</form:form>
<h3><a class="two" href="showloginform.htm">Back to LogIn</a></h3>
</body>
</html>