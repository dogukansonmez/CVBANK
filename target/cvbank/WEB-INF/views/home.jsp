<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>CV BANK</title>
</head>
<body>
<h1>
	CV BANK
</h1>

<form method="POST" action="/cvbank">
   <table>
    <tr>
   <H2> SEARCH CANDIDATE </H2>
    </tr>
    <br>
    <tr>
        <td><input type="text" Name="searchBox" /></td>
    </tr>
    <HR>
    <tr>
         <td>
            <input type="reset" value="clear"/>
            <input type="submit" value="Submit"/>
        </td>
    </tr>
     <HR>
</table>
</form>

<HR>
<a href="deposit">Add New Candidate</a>
</body>
</html>
