<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="utilities.Iata"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//System.out.println(request.getParameter("usrname"));
%>
<%
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="./js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="./js/picker.js" type="text/javascript"></script>
<script src="./js/picker.date.js" type="text/javascript"></script>
<script src="./js/picker.time.js" type="text/javascript"></script>
<script src="./js/legacy.js" type="text/javascript"></script>
<script src="./js/datescript.js" type="text/javascript"></script>


<title>Flight Search Query</title>
<style type="text/css">
html {
	background: url(flight.jpg) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	position: relative;
	font-family: 'Open Sans', Helvetica, sans-serif;
}

h3 {
	width: 300px;
	line-height: 43px;
	margin: 50px auto 20px;
	font-size: 19px;
	font-weight: 500;
	color: white;
	color: rgba(255, 255, 255, 0.95);
	text-align: center;
	text-shadow: 0 1px rgba(0, 0, 0, 0.3);
	background: #d7604b;
	border-radius: 3px;
	background-image: -webkit-linear-gradient(top, #dc745e, #d45742);
	background-image: -moz-linear-gradient(top, #dc745e, #d45742);
	background-image: -o-linear-gradient(top, #dc745e, #d45742);
	background-image: linear-gradient(to bottom, #dc745e, #d45742);
	-webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.1), inset 0 0 0
		1px rgba(255, 255, 255, 0.05), 0 0 1px 1px rgba(0, 0, 0, 0.1), 0 1px
		3px rgba(0, 0, 0, 0.3);
	box-shadow: inset 0 1px rgba(255, 255, 255, 0.1), inset 0 0 0 1px
		rgba(255, 255, 255, 0.05), 0 0 1px 1px rgba(0, 0, 0, 0.1), 0 1px 3px
		rgba(0, 0, 0, 0.3);
}

.
.search input[type="submit"] {
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

.logo {
	float: right;
	align: right;
}

.hbtn {
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

.sbtn {
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

a.log:hover {
	color: #f90;
	text-decoration: underline;
}

.nav a {
	text-decoration: none;
	color: #fff;
	display: block;
	transition: .3s background-color;
}

.nav a:hover {
	background-color: #005f5f;
}

.nav a.active {
	background-color: #fff;
	color: #444;
	cursor: default;
}

.nav ul {
	list-style: none;
	background-color: #444;
	text-align: center;
	padding: 0;
	margin: 0;
}

.nav li {
	font-family: 'Oswald', sans-serif;
	font-size: 1.2em;
	line-height: 10px;
	height: 10px;
	border-bottom: 1px solid #888;
}

li {
	float: right;
	align: right
}

header {
	height: 1px;
}
</style>
<link rel="stylesheet" type="text/css" href="./css/default.css" />
<link rel="stylesheet" type="text/css" href="./css/default.date.css" />
<link rel="stylesheet" type="text/css" href="./css/default.time.css" />
<link rel="stylesheet" type="text/css" href="./css/menustyle.css" />
</head>
<body>
	<div id='cssmenu'>
		<ul>
			<li><a href='#'>Welcome <c:out value="${username}" />  From: <c:out value="${organization}" /></a></li>
			<li style="float: right"><a
				href="Logout">Logout</a></li>
			<li style="float: right"><a href="Shoppingcart.jsp">Shopping
					Cart</a></li>

		</ul>
	</div> 
	<div align="center" class="search">
		<form method="post" action="FlightSearchQuery" name="flightsearch">

			<table align="center">
				<h3>Flight Search Query</h3>
				<tr>
					<td>Source:</td>
					<td><select id="source" name="source" style="width: 170px;">
							<%
								Iata temp = new Iata();
								for (String source : temp.airports) {
							%>

							<option value=<%=source%>><%=source%></option>
							<%
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td>Destination:</td>
					<td><select id="destination" name="destination"
						style="width: 170px;">
							<%
								for (String source : temp.airports) {
							%>
							<option value=<%=source%>><%=source%></option>
							<%
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td>Date of Journey:</td>
					<td><input type="text" placeholder="yyyy-mm-dd"
						class="datepicker" name="doj" style="width: 170px;"></td>
				</tr>
				<tr>
					<td>class</td>
					<td><select id="class" name="class">
							<option value="none"></option>
							<option value="Economy">Economy</option>
							<option value="Business">Business</option>
							<option value="FirstClass">FirstClass</option>
					</select></td>
				<tr>
					<td colspan="2"><input type="submit" value="Search"
						class="sbtn"></td>

					<td colspan="2"><input type="button" value="History"
						class="hbtn" onclick="location='BookingHistory'"></td>

				</tr>
			</table>
		</form>
	</div>



</body>
</html>