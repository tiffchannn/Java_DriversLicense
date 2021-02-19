<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
	<h1>New License</h1>
	<form:form action="/licenses/new" method="post" modelAttribute="license">
	    <p>
	    <!-- Dropdown Menu showing all names in database -->
	    <form:label path="person">Person: </form:label>
	        <form:select path="person" name="person">
	        	<c:forEach items="${personsList}" var="person">
	        		<form:option value="${person.id}"><c:out value="${person.firstName} ${person.lastName}"/></form:option>
        		</c:forEach>
       		</form:select> 
	    </p>
	    <p>
	        <form:label path="state">State:</form:label>
	        <form:input path="state"/>
	    </p><p>
	        <form:label path="expirationDate">Expiration Date:</form:label>
	        <form:input type="date" path="expirationDate"/>
	    </p>
	    <input type="submit" value="Create"/>
	</form:form> 
	<p><a href="/persons">Back</a></p>


</body>
</html>