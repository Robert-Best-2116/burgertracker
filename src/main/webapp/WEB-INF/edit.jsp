<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Your Review!</title>
</head>
<body>
<h1>Edit Your Review!</h1>
<form:form action="/burgers/${burger.id}" method="post" modelAttribute="burger">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="burgerName">Burger Name</form:label>
        <form:input path="burgerName"/>
        <form:errors path="burgerName"/>
    </p>
    <p>
        <form:label path="resturantName">Restaurant Name</form:label>
        <form:textarea path="resturantName"/>
        <form:errors path="resturantName"/>
    </p>
    <p>
        <form:label path="notes">Notes</form:label>
        <form:input path="notes"/>
        <form:errors path="notes"/>
    </p>
    <p>
        <form:label path="rating">Rating</form:label>
        <form:input type='number' path='rating' min="0" max="5"/>
        <form:errors path="rating"/>    
    </p>    
    <input type="submit" value="Submit" class="button"/>
</form:form>

</body>
</html>