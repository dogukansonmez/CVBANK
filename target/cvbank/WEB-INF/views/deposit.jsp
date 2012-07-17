<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Add New Candidate</title>
</head>
<body>
<form:form method="POST" commandName="candidate" style="padding:8px">
    <p>
        First Name : <form:input path="firstName"/>
    </p>
    <p>
        Last Name : <form:input path="lastName"/>
    </p>
    <p>
        Address : <form:input path="address"/>
    </p>
    <p>
        Email : <form:input path="email"/>
    </p>
    <p>
        Phone Number : <form:input path="phoneNumber"/>
    </p>
    <p>
        Resume :<br><TEXTAREA Name="resume" rows="4" cols="50"></TEXTAREA>
    </p>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
