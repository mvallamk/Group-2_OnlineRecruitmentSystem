<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
a.two:hover {font-size:150%;}
a.two {color: #3110B6;}
tr:hover{background-color:#46E8DE}
</style>
</head>
<body background="images/bg1.jpg">
<h1 style="color:blue;text-align:center">Pick your operation</h1>
<table bgcolor="#E4E47C"  align="center" cellspacing="5" width=300 border=2 >

<tr align=center valign=middle><td><a class="two" href="addresumeform.htm">Add Resume</a></td></tr>
<tr align=center valign=middle><td><a class="two" href="modifyresumeform.htm">Modify Resume</a></td></tr>
<tr align=center valign=middle><td><a class="two" href="search.htm">Search Jobs</a></td></tr>
</table>
<h3 style="text-align:center">${message}</h3>
<h3><a class="two" href="signout.htm">Sign Out</a></h3>
</body>
</html>