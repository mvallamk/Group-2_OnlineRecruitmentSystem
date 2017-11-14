<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
a.two:link {
	color: #004BAA;
}

a.two:hover {
	font-size: 150%;
}
</style>
</head>
<body background="images/bg1.jpg">
	<center>
		<h2>The jobs that matched your criteria</h2>
		<table>
			<tr>
				<th>Job ID</th>
				<th>Company Id</th>
				<th>Position Required</th>
				<th>Number Required</th>
				<th>Experience Required</th>
				<th>Qualification Required</th>
				<th>Job Location</th>
				<th>Job Description</th>
				<c:forEach items="${jobs}" var="job">
					<tr>
						<td>${job.jobID}</td>
						<td>${job.companyId}</td>
						<td>${job.positionRequired}</td>
						<td>${job.numberRequired}</td>
						<td>${job.experienceRequired}</td>
						<td>${job.qualificationRequired}</td>
						<td>${job.jobLocation}</td>
						<td>${job.jobDescription}</td>
						<td><a
							href="apply.htm?jobID=${job.jobID}&&companyId=${job.companyId}">Apply</a></td>
					</tr>
				</c:forEach>
		</table>
	</center>
	<h3>
		<a class="two" href="signout.htm">Sign Out</a>
	</h3>
</body>
</html>