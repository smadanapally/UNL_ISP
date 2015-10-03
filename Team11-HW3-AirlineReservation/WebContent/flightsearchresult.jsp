<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="beans.Flight,java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Search Results</title>
<style>
html {
background: url(flight.jpg) no-repeat center center fixed;
-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	position:relative;
}
.search input[type="button"]
{
width: 100px;
	background: #33CCFF;
	font-weight: bold;
	color: white;
	border: 0 none;
	border-radius: 1px;
	cursor: pointer;
	padding: 10px 5px;
	margin: 10px 5px;
}
a.log {
	color: #FFFF66;
	font-size: 15px;
	text-decoration: none;
	float: right;
}
table tr td{
position: relative;

}
td{
text-align: center;
}
div{
padding-top:150px;
}
a.log:hover {
	color: #f90;
	text-decoration: underline;
}
header {
	height: 1px;
}
.logo{
width: 100px;
	background: #2E3543;
	font-weight: bold;
	color: white;
	border: 0 none;
	border-radius: 1px;
	cursor: pointer;
	padding: 10px 5px;
	margin: 10px 5px;
}
input[type="submit"]
{
width: 100px;
	background: #33CCFF;
	font-weight: bold;
	color: white;
	border: 0 none;
	border-radius: 1px;
	cursor: pointer;
	padding: 10px 5px;
	margin: 10px 5px;
}

.logo{
float:right;
align:right;
}
</style>
<link rel="stylesheet" type="text/css" href="./css/default.css" />
<link rel="stylesheet" type="text/css" href="./css/default.date.css" />
<link rel="stylesheet" type="text/css" href="./css/default.time.css" />
<link rel="stylesheet" type="text/css" href="./css/menustyle.css" />
</head>
<body>

<body>
	 <c:if test="${sessionScope.user==null}">
	 <c:redirect url="Login.jsp"/>
</c:if>

	<div id='cssmenu'>
		<ul>
			<li><a href='#'>Welcome  <c:out value="${username}" />  From: <c:out value="${organization}" /></a></li>
			<li style="float: right"><a
				href="Logout">Logout</a></li>
			<li style="float: right"><a href="Shoppingcart.jsp">Shopping
					Cart</a></li>

		</ul>
	</div>
<form method="post" action="FlightSearchResultServlet">
	
	<div align="center" class="search">
		<table>
			<tr>
				<th>Flight Number</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Departure Time</th>
				<th>Arrival Time</th>
				<th>Number of Stops</th>
				<th>Cost</th>
				<th>Option</th>
			</tr>
<%
int i=0;

%>
<c:forEach items="${sessionScope.flightdetails}" var="current">
        <tr>
          <td><c:out value="${current.flightno}"/></td>
          <td><c:out value="${current.source}" /></td>
          <td><c:out value="${current.destination}" /></td>
          <td><c:out value="${current.departure}" /></td>
          <td><c:out value="${current.arrival}" /></td>
          <td><c:out value="1" /></td>
          <td><c:out value="$100" /></td>
          <td><input type="radio" name="flight" value=<%=i %>></td>
					<%++i; %>
        </tr>
 </c:forEach>
	<tr>
	<td colspan="8"><input type="submit" value="Submit" align="middle"></td>
	</tr>
			
		</table>
	</div>
	</form> 
</body>
</html>