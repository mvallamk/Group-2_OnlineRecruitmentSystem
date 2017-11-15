<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
a {
	font-size: 30px;
}

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
		<!-- <h3 align="right"><a href="backtocand.htm">Back</a></h3> -->
		<h2>Employee Recruitment System: Search Jobs</h2>

		<form:form action="byqualification.htm"
			modelAttribute="jobRequirements1" method="post">
		
				
				By Qualification :
				<form:select path="qualificationRequired">
				<form:options items="${qualifications}" />
			</form:select>
			<button type="submit">search</button>

		</form:form>
		<br><br><br><br>

		<form:form action="byposition.htm" modelAttribute="jobRequirements2"
			method="post">
			
					By Position:
				<form:select path="positionRequired">
				<form:options items="${positions}" />
			</form:select>
			<button type="submit">search</button>

		</form:form>
		<br><br><br><br>
		<form:form action="byexperience.htm" modelAttribute="jobRequirements3"
			method="post">


			<form:label path="experienceRequired">
					By Experience:
				</form:label>
			<form:input type="number" path="experienceRequired"></form:input>
			<button type="submit">search</button>

		</form:form>
		<br><br><br><br>
		<form:form action="bylocation.htm" modelAttribute="jobRequirements4"
			method="post">


			<form:label path="jobLocation">
					By Location:
				</form:label>
			<form:select path="jobLocation">
				<form:options items="${cities}" />
			</form:select>
			<button type="submit">search</button>

		</form:form>
	</center>

	<h3>
		<a class="two" href="backtocandidate.htm">Home</a>
	</h3>
</body>
</html>

