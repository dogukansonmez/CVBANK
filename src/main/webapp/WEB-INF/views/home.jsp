<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>CV BANK</title>
</head>
<body>
<h1>
	CV BANK
</h1>
 <H2> SEARCH CANDIDATE </H2>
 <HR>
<form:form method="POST"  commandName="searchBox" style="padding:8px">
    <p>
       Any Of These Words : <form:input path="anyOfTheseWords"/>
    </p>
    <p>
       All These Words: <form:input path="allTheseWords"/>
    </p>
    <p>
        This Exact Word or Phrase : <form:input path="thisExactWordOrPhrase"/>
    </p>
    <p>
        None Of These Words : <form:input path="noneOfTheseWords"/>
    </p>
    <p>
        Number Of Result: <form:input path="numberOfResult"/>
    </p>
      <input type="submit" value="search"/>
</form:form>
<HR>
<a href="deposit">Add New Candidate</a>
</body>
</html>
