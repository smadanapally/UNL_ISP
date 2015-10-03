<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="beans.Booking"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction Confirmation</title>
<style>
html {
	background: url(flight.jpg) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	position: relative;
}

h3.conf1 {
	width: 270px;
	line-height: 43px;
	margin: 50px auto 20px;
	font-size: 19px;
	font-weight: 500;
	color: white;
	color: rgba(255, 255, 255, 0.95);
	text-align: center;
	text-shadow: 0 1px rgba(0, 0, 0, 0.3);
	background-color: #66FF99;
	border-radius: 3px;
	-webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.1), inset 0 0 0
		1px rgba(255, 255, 255, 0.05), 0 0 1px 1px rgba(0, 0, 0, 0.1), 0 1px
		3px rgba(0, 0, 0, 0.3);
	box-shadow: inset 0 1px rgba(255, 255, 255, 0.1), inset 0 0 0 1px
		rgba(255, 255, 255, 0.05), 0 0 1px 1px rgba(0, 0, 0, 0.1), 0 1px 3px
		rgba(0, 0, 0, 0.3);
}

h5.conf {
	width: 270px;
	line-height: 43px;
	margin: 50px auto 20px;
	font-size: 19px;
	font-weight: 500;
	color: white;
	color: rgba(255, 255, 255, 0.95);
	text-align: center;
	text-shadow: 0 1px rgba(0, 0, 0, 0.3);
	background-color: #66FF99;
	border-radius: 3px;
	-webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.1), inset 0 0 0
		1px rgba(255, 255, 255, 0.05), 0 0 1px 1px rgba(0, 0, 0, 0.1), 0 1px
		3px rgba(0, 0, 0, 0.3);
	box-shadow: inset 0 1px rgba(255, 255, 255, 0.1), inset 0 0 0 1px
		rgba(255, 255, 255, 0.05), 0 0 1px 1px rgba(0, 0, 0, 0.1), 0 1px 3px
		rgba(0, 0, 0, 0.3);
}

input[type="button"] {
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

div.wrapper {
	width: 50%;
	margin-right: auto;
	margin-left: auto
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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
	
</script>
<script type="text/javascript">
function printdata()
{
	window.print();
	}
</script>
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

	<%
		Booking b = new Booking();
		b = (Booking) session.getAttribute("Confirm");
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
	<div align="center">
		<table>


			<tr>
				<th>Booking IDr</th>
				<th>Account id</th>
				<th>Number of Tickets</th>
				<th>Total Cost</th>
			</tr>
			<tr>
				<td><%=b.getBooking_id()%></td>
				<td><%=b.getAccount_id()%></td>
				<td><%=b.getNumber_of_seats()%></td>
				<td><%=b.getTotal_cost()%></td>
			</tr>
			<tr>
				<th colspan="2"><h5 class="conf">Your Purchase Has Been
						Confirmed</h5></th>
			</tr>
			<tr>
				<td colspan="3"><input type="button" value="Home"
					onclick="location='flightsearchquery.jsp'"></td>
			</tr>
		</table>
	</div>
	<div>
	<table>
	<tr>
						<td>Name</td>
						<td><input type="text" name="name" value="" class="input1"
							id="user1"></td>

					</tr>
					<tr>
						<td>Age</td>
						<td><input type="text" name="age" value="" class="input1"
							id="user2"></td>

					</tr>
					<tr>
						<td>Sex</td>
						<td><input type="text" name="sex" value="" class="input1"
							id="user3"></td>

					</tr>
					<tr>
						<td>Mobile no</td>
						<td><input type="text" name="mob" value="" class="input1"
							id="user4"></td>

					</tr>
					<tr>
					<td>
					<input type="button" value="Print" onclick="printdata()">
					</td>
					</tr>
					
	</table>
	</div>
</body>
</html>