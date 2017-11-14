<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript" src="javascript/validations.js"></script>
</head>
<body background="images/bg1.jpg">

	<h1 style="font-size: 300%; text-align: center">Resume</h1>

	<a class="two" href="addpersonalform.htm">Add Personal Details</a>

	<c:if test="${candPers ne null}">
		<form:form name="personalDetails" action="savepersonal.htm"
			modelAttribute="candPers" method="post">
			<table bgcolor="#E4E47C" align="center" border="1">
				<tr>
					<td><form:label path="candidateName">Name</form:label></td>
					<td><form:input path="candidateName" pattern="[A-Za-z\s]+"
							required="required" maxlength="20"></form:input> <form:errors
							path="candidateName"></form:errors></td>
				</tr>

				<tr>
					<td><form:label path="address">Address</form:label></td>
					<td><form:textarea path="address" required="TRUE" rows="5"
							size="10"></form:textarea> <form:errors path="address"></form:errors></td>
				</tr>

				<tr>
					<td><form:label path="dob">Date of Birth</form:label></td>
					<td><form:input type="date" path="dob" name="dateOfBirth"
							max="${currentDate}"></form:input> <form:errors path="dob"></form:errors></td>
				</tr>

				<tr>
					<td><form:label path="emailId">Email Id</form:label></td>
					<td><form:input path="emailId"
							pattern="^[A-Za-z0-9._%+-]+@{1}[A-Za-z0-9.-]+.{1}[A-Za-z]{2,6}$"
							required="TRUE" title="Enter Valid MailId" maxlength="30"></form:input>
						<form:errors path="emailId"></form:errors></td>
				</tr>

				<tr>
					<td><form:label path="contactNumber">Contact Number</form:label></td>
					<td><form:input path="contactNumber" pattern="[0-9]{10}"
							required="TRUE" title="Enter a ten digit number"></form:input> <form:errors
							path="contactNumber"></form:errors></td>
				</tr>

				<tr>
					<td><form:label path="maritalStatus">Marital Status</form:label></td>
					<td><form:radiobutton path="maritalStatus" value="Married" />Married
						<form:radiobutton path="maritalStatus" value="Unmarried"
							checked="true" />Unmarried <form:errors path="maritalStatus"></form:errors></td>
				</tr>

				<tr>
					<td><form:label path="gender">Gender</form:label></td>
					<td><form:radiobutton path="gender" value="Male" />Male <form:radiobutton
							path="gender" value="Female" />Female <form:radiobutton
							path="gender" value="Others" checked="true" />Others <form:errors
							path="gender"></form:errors></td>
				</tr>

				<tr>
					<td><form:label path="passportNumber">Passport Number</form:label></td>
					<td><form:input path="passportNumber"
							pattern="^[A-Z]{1}[0-9]{7}$" required="TRUE" title="A1234567"></form:input>
						<form:errors path="passportNumber"></form:errors></td>
				</tr>

				<tr>
					<td></td>
					<td><button type="submit">Save</button></td>
				</tr>
			</table>
		</form:form>
	</c:if>

	<br>
	<br>
	<br>
	<br>
	<a class="two" href="addqualform.htm">Add Qualification Details</a>
	<c:if test="${candQual ne null }">
		<h2 style="text-align: center">Enter Qualification Details</h2>
		<form:form name="qualificationDetails" action="savequal.htm"
			modelAttribute="candQual" method="post">
			<table bgcolor="#E4E47C" cellspacing="5" align="center" border="1">
				<tr align=center valign=middle>
					<th><form:label path="qualificationName">Qualification</form:label></th>
					<th><form:label path="specializationArea">Specialization Area</form:label></th>
					<th><form:label path="collegeName">Institution Name</form:label></th>
					<th><form:label path="universityName">University/Board</form:label></th>
					<th><form:label path="yearOfPassing">Year of Passing</form:label></th>
					<th><form:label path="percentage">Percentage</form:label></th>
				</tr>

				<tr align=center valign=middle>
					<td><form:select path="qualificationName"
							name="qualifications">
							<form:options items="${qualifications}" />
						</form:select> <form:errors path="qualificationName"></form:errors></td>
					<td><form:input path="specializationArea"
							pattern="^[A-Za-z]{1}[A-Za-z. ]{1,}$" required="TRUE"
							title="Only letters and ."></form:input> <form:errors
							path="specializationArea"></form:errors></td>
					<td><form:input path="collegeName"
							pattern="^[A-Za-z]{1}[A-Za-z. ]{1,}$" required="TRUE"
							title="Only letters and ."></form:input> <form:errors
							path="collegeName"></form:errors></td>
					<td><form:input path="universityName"
							pattern="^[A-Za-z]{1}[A-Za-z. ]{1,}$" required="TRUE"
							title="Only letters and ."></form:input> <form:errors
							path="universityName"></form:errors></td>
					<td><form:input path="yearOfPassing" max="${currentYear}"
							type="number" pattern="^[1-9]{1}[0-9]{3}$" required="TRUE"
							title="1999"></form:input> <form:errors path="yearOfPassing"></form:errors></td>
					<td><form:input path="percentage"
							pattern="[0-9]{1,2}[.]{0,1}[0-9]{0,2}" required="TRUE" title="99"></form:input>
						<form:errors path="percentage"></form:errors></td>
				</tr>
				<tr>
					<td style="text-align: center;" colspan="6"><input
						type="submit" value="Save" /></td>
				</tr>
			</table>

		</form:form>
	</c:if>

	<br>
	<br>
	<br>
	<br>
	<a class="two" href="addworkform.htm">Add Work History Details</a>
	<c:if test="${candWork ne null }">
		<h2 style="text-align: center">Enter Work History Details</h2>
		<form:form name="workHistory" action="saveworkhist.htm"
			modelAttribute="candWork" method="post"
			onsubmit="return validationsWorkDates()">
			<table bgcolor="#E4E47C" cellspacing="5" align="center" border="1">
				<tr align=center valign=middle>
					<td><form:label path="whichEmployer">Previous Employer</form:label></td>
					<td><form:input path="whichEmployer"
							pattern="^[A-Z]{1}[a-z]{1,}[1-9]{0,}$" required="TRUE"
							title="Previous1"></form:input> <form:errors path="whichEmployer"></form:errors></td>
				</tr>
				<tr align=center valign=middle>
					<td><form:label path="contactPerson">Contact Person</form:label></td>
					<td><form:input path="contactPerson"
							pattern="^[A-Z]{1}[a-z]{0,}[ ]{1}[A-Z]{1}[a-z]{0,}$"
							required="TRUE" title="Mohit Deshmukh" maxlength="30"></form:input>
						<form:errors path="contactPerson"></form:errors></td>
				</tr>
				<tr align=center valign=middle>
					<td><form:label path="positionHeld">Position Held</form:label></td>
					<td><form:input path="positionHeld" pattern="[A-Za-z ]{1,}"
							required="TRUE" title="Senior Analyst" maxlength="30"></form:input>
						<form:errors path="positionHeld"></form:errors></td>
				</tr>
				<tr align=center valign=middle>
					<td><form:label path="companyName">Company Name</form:label></td>
					<td><form:input path="companyName" pattern="[A-Za-z.& ]{1,}"
							required="TRUE" title="F.S. Finance & Consulting" maxlength="30"></form:input>
						<form:errors path="companyName"></form:errors></td>
				</tr>
				<tr align=center valign=middle>
					<td><form:label path="employmentFrom">Employment from </form:label></td>
					<td><form:input type="date" path="employmentFrom"
							name="employmentFrom" max="${currentDate}"></form:input> <form:errors
							path="employmentFrom"></form:errors></td>
				</tr>
				<tr align=center valign=middle>
					<td><form:label path="employmentTo">Employment to</form:label></td>
					<td><form:input type="date" path="employmentTo"
							name="employmentTo" max="${currentDate}"></form:input> <form:errors
							path="employmentTo"></form:errors></td>
				</tr>
				<tr align=center valign=middle>
					<td><form:label path="reasonForLeaving">Reasons for Leaving</form:label></td>
					<td><form:textarea path="reasonForLeaving"></form:textarea> <form:errors
							path="reasonForLeaving"></form:errors></td>
				</tr>
				<tr align=center valign=middle>
					<td><form:label path="responsibilities">Responsibilities</form:label></td>
					<td><form:textarea path="responsibilities" /> <form:errors
							path="responsibilities"></form:errors></td>
				</tr>
				<tr align=center valign=middle>
					<td><form:label path="hrRepName">Hr Name</form:label></td>
					<td><form:input path="hrRepName"
							pattern="^[A-Z]{1}[a-z]{0,}[ ]{1}[A-Z]{1}[a-z]{0,}$"
							required="TRUE" title="Mohit Deshmukh" maxlength="30"></form:input>
						<form:errors path="hrRepName"></form:errors></td>
				</tr>
				<tr align=center valign=middle>
					<td><form:label path="hrRepContactNumber">Hr Contact Number</form:label></td>
					<td><form:input path="hrRepContactNumber" pattern="[0-9]{10}"
							required="TRUE" title="Enter a ten digit number" /> <form:errors
							path="hrRepContactNumber"></form:errors></td>
				</tr>

				<tr>
					<td style="text-align: center;" colspan="2"><input
						type="submit" value="Save" /></td>
				</tr>



			</table>


		</form:form>
	</c:if>
	<br>
	<br>
	<a class="two" href="backtocandidate.htm">Home</a>

</body>
</html>