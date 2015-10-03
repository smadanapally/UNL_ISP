<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="beans.Booking,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking History</title>
</head>
<style>
html {
	background: url(flight.jpg) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	position: relative;
}

a.log {
	color: #FFFF66;
	font-size: 15px;
	text-decoration: none;
	float: right;
}

.search input[type="button"] {
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

a.log:hover {
	color: #f90;
	text-decoration: underline;
}

div {
	padding-top: 150px;
}
td{

text-align:center;
}
div.wrapper {
	width: 100%;
	margin-right: auto;
	margin-left: auto;
	padding-top: 150px;
}

.logo {
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

.logo {
	float: right;
	align: right;
}
</style>
<link rel="stylesheet" type="text/css" href="./css/default.css" />
<link rel="stylesheet" type="text/css" href="./css/default.date.css" />
<link rel="stylesheet" type="text/css" href="./css/default.time.css" />
<link rel="stylesheet" type="text/css" href="./css/menustyle.css" />

</head>
<body>
	<%
		//allow access only if session exists
		String user = null;
		if (session.getAttribute("user") == null) {
			response.sendRedirect("Login.jsp");
		} else
			user = (String) session.getAttribute("user");
		String userName = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user"))
					userName = cookie.getValue();
				if (cookie.getName().equals("JSESSIONID"))
					sessionID = cookie.getValue();
			}
		}
	%>
	<div id='cssmenu'>
		<ul>
			<li><a href='#'>Welcome <%=user%></a></li>
			<li style="float: right"><a
				href="<%=request.getContextPath()%>/Logout">Logout</a></li>
			<li style="float: right"><a href="Shoppingcart.jsp">Shopping
					Cart</a></li>

		</ul>
	</div>
	<div align="center" class="search">

		<table>
			<tr>
				<th>Booking IDr</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Departure Time</th>
				<th>Number of Tickets</th>

			</tr>
			<%
				ArrayList<Booking> L1 = (ArrayList<Booking>) session.getAttribute("history");
				for (Booking A : L1) {
			%>
			<tr>
				<td><%=A.getBooking_id()%></td>
				<td><%=A.getWings().getSource()%></td>
				<td><%=A.getWings().getDestination()%></td>
				<td><%=A.getWings().getDeparture()%></td>
				<td><%=A.getNumber_of_seats()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>