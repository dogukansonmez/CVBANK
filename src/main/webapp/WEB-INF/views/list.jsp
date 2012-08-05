<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<h1>Listing Products</h1>
<c:forEach items="${candidates}" var="candidate">
<a href="edit?id=${candidate.id}">Name : ${candidate.firstName} ${candidate.firstName}, Phone:${candidate.phoneNumber}, Email: Phone:${candidate.email}   </a>
<br />
</c:forEach>
<a href="deposit"> Deposit CV</a>
</body>
</html>