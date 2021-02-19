<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Everyone!</title>
</head>
<body>
	<h1>All People</h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>License Info</th>
            <th>State</th>
            <th>Expiration Date</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${persons}" var="person">
        <tr>
            <td><a href="/persons/${person.id}"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></a></td>
            <td><c:out value="${person.license.number}"/></td>
            <td><c:out value="${person.license.state}"/></td>
            <td><c:out value="${person.license.expirationDate}"/></td>
        </tr>
        </c:forEach>
        <tr>
        	<td><a href="/persons/new">New Person</a></td>
        	<td><a href="/licenses/new">New License</a></td>
        </tr>
    </tbody>
</table>
	

</body>
</html>