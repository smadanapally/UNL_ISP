<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="beans.Flight,java.util.ArrayList,java.text.SimpleDateFormat"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View and book</title>
<style type="text/css">
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

a.log:hover {
	color: #f90;
	text-decoration: underline;
}

input[type="submit"] {
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

div {
	padding-top: 150px;
}

table tr td {
	position: relative;
	border: 1px solid black;
}

td {
	text-align: center;
}

header {
	height: 1px;
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
	function getdata() {
		$("#number").attr("disabled", "disabled");
		$("#ATC").hide();
		$("p").show();
		var ticketno = $("#number").val();
		$.get("ViewAndBookServlet",{
			number : ticketno
		}, function(data, status) {
		//Insert the result in your page
		$("#number").attr("disabled", false);
			$("#results").html(data);
			$("#ATC").show();
			$("p").hide();
		});
		}
</script>
</head>
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
	<c:set var="index" value="${sessionScope.index }" scope="session"  /> 
	<div align="center">
		<p>${message}</p>
		<table>
			<tr>
				<td>Source</td>
								<td><input type="text" name="source" id="source"
					value="<c:out value="${sessionScope.flightdetails[index].source}"/>" disabled="disabled"> 
								</td>
			</tr>
			<tr>
				<td>Destination</td>
				<td><input type="text" name="destination" id="destination"
					value="<c:out value="${sessionScope.flightdetails[index].destination}"/>" disabled="disabled"></td>
			</tr>
			<tr>
				<td>Flight no</td>
				<td><input type="text" name="flightno" id="flightno"
					value="<c:out value="${sessionScope.flightdetails[index].flightno}"/>" disabled="disabled"></td>
			</tr>

			<tr>
				<td><label for="stops">Stops</label></td>
				<td><input type="text" value="1" name="stops"
					disabled="disabled"></td>
			</tr>
			<tr>
				<td><label for="duration">Duration</label></td>
				<td><input type="text" value="5Hrs" name="duration"
					disabled="disabled"></td>
			</tr>
			<tr>
				<td><label for="operator">Operator</label></td>
				<td><input type="text" name="operator" id="operator"
					value="<c:out value="${sessionScope.flightdetails[index].plane}"/>" disabled="disabled"></td>
			</tr>
			<tr>
				<td><label for="stops">Number of seats</label></td>
				<td><input type="text" id="number" name="seat"></td>
			</tr>
			<tr>
				<td><input id="ATC" type="button" value="Add to Cart"
					onclick="getdata()"><p hidden='true' text="Loading...">Loading...</p></td>
				<td><input type="button" value="Back to Search Result"
					onclick="location='flightsearchquery.jsp'"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="button" value="Checkout"
					onclick="location='Shoppingcart.jsp'"></td>
			</tr>
		</table>
	</div>
	<q align='center' id="results"></q>
	<!-- </form>   -->
</body>
</html>