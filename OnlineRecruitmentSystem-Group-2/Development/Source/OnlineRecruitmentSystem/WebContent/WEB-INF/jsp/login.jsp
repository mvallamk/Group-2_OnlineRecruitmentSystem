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
	<h1 style="text-align:center">Login</h1>
	<p align="center" style="color: Red">${message}</p>
	<form action="checklogin.htm" method="post">
		<table bgcolor="#E4E47C" align="center">
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="loginId"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>

			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>

	<a class="two" href="showsignupform.htm">Signup</a>

</body>
</html>