<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Burgers!!</title>
</head>
<body>

<h1>Burger Tracker!!</h1>

<table>
  <tr>
    <th>Burger Name!</th>
    <th>Resturant Name!!</th>
    <th>Rating!!(out of 5!!)</th>
    <th>Actions</th>
  </tr>
  	
  	<c:forEach var="oneBurger" items="${allBurgers}">
  		<tr>
    		<td><c:out value = "${oneBurger.burgerName}"/></td>
    		<td><c:out value = "${oneBurger.resturantName}"/></td>
    		<td><c:out value = "${oneBurger.rating}"/></td>
    		<td><a href="/burgers/${oneBurger.id}/edit" >Edit</a></td>
  		</tr>
  	</c:forEach>
</table>

<h2>Add Your Favorite Burgers!!</h2>

	<form:form action="/burger/new" method="post" modelAttribute="burger" >
		<div>
			<form:label path="burgerName">Burger Name??</form:label>
			<form:input type="text" path="burgerName"/>
			<form:errors path="burgerName" class="text-danger" />
		</div>
		<div>
			<form:label path="resturantName">Restaurant Name?</form:label>
			<form:input type='text' path='resturantName'/>
			<form:errors path="resturantName" class="text-danger" />
		</div>
		<div>
			<form:label path="notes">Notes? </form:label>
			<form:input type='text' path='notes'/>
			<form:errors path="notes" class="text-danger" />
		</div>
		<div>
			<form:label path="rating">Rating Out of Five!</form:label>
			<form:input type='number' path='rating' min="0" max="5"/>
			<form:errors path="rating" class="text-danger" />		
		</div>
		<div>
			<input type='submit' value='Submit' class="button">
		</div>
	</form:form>


</body>
</html>