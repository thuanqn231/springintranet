<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"/>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
</head>
<body>
<c:catch var = "exception"><% int x = 5/0; %></c:catch>
<c:if test="${exception != null }">
Error: ${exception.message }
</c:if>
<br/>
<c:if test='${name =="Nguyen Thuan"}'>Anh Thuan dep trai</c:if>
<br/>
<c:forTokens items="Today, rain , strom, suny" delims="," var ="name">
	<c:out value="${name }"></c:out><br/>
</c:forTokens>
<br/>
<c:forEach items="${list}" var = "key"><c:out value="${key.getName() }"></c:out></c:forEach>
	<a id ="title" href="detail">Detail</a>
	<c:set var="name" value="${age } Ngon lanh canh dao"/>
	<h3>Name: </h3> <c:out value="${name }"/>
	<h3>Age: <c:out value = "${age}"/></h3>
	
	

	<h3>Name: </h3> <c:out value="${name }"/>
	
	<form action="detail" method="post">
		<input type="text" name="username"/><br/>
		<input type="password" name="password"/><br/>
		<input type="submit" value="Login"/>
	</form>
	<br/>
		<form action="detail" method="post">
		<input type="text" name="name"/><br/>
		<input type="text" name="age"/><br/>
		<input type="text" name="address"/><br/>
		<input type="submit" value="Submit"/>
	</form>

</body>
</html>