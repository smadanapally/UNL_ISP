<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="beans.Booking,beans.Flight,java.util.ArrayList,java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
<style>
html {
	background: url(flight.jpg) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	position: relative;
}

div.search {
	padding-top: 150px;
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

div.wrapper {
	width: 50%;
	margin-right: auto;
	margin-left: auto;
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
$(document).ready(function() {
	$("#loading").hide();
	$("#confirming").hide();
	$("#action").click(function() {
		$("#loading").show();
		console.log("1");
		var total = $("#total").val();
		var accountno = $("#acno").val();
		var holder = $("#holder").val();
		var routingno = $("#rtng").val();
		$("#action").hide();
		//$("#proceed").hide();
		$.post("http://localhost:8080/Team11-HW3-Banking/BankAction", 
			{
			acno : accountno,
			total : total,
			holder : holder,
			routing : routingno
			},
			function(data, responseJson) {
				console.log("2");
				
				$("#loading").hide();
				$("#action").show();
				if(data==1){
					alert("Sucess");
					$("#conforming").show();
					$.post("http://localhost:8080/Team11-HW3-AirlineReservation/TransactionConfirmation", 
							{
							acno : accountno,
							},
							function(data,responseJson){
								console.log("2");
								$("#details").hide();
								$("#proceed").html("Order has been confirmed and the OrderId : "+data);
								$("#conforming").hide();
								
								});

					
					}
				else
						alert("Failure");
			});

	});
});


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

	<div class="search" align="center" id="table">

		<table>

			<tr>
				<th>Source</th>
				<th>Destination</th>
				<th>Flight no:</th>
				<th>Departure Time</th>
				<th>Arrival Time</th>
				<th>Stops</th>
				<th>Total</th>
			</tr>
			
			<c:forEach items="${sessionScope.Shopping}" var="current">
			<tr>

				<td><input type="text" name="source" id="source"
					value="<c:out value="${current.source}"/>" disabled="disabled"></td>

				<td><input type="text" name="dest" id="source"
					value="<c:out value="${current.destination}"/>" disabled="disabled"></td>

				<td><input type="text" name="flightid" id="source"
					value="<c:out value="${current.flightno}"/>" disabled="disabled"></td>


				<td><input type="text" name="departure" id="source"
					value="<c:out value="${current.departure}"/>" disabled="disabled"></td>
				<td><input type="text" name="departure" id="source"
					value="<c:out value="${current.arrival}"/>" disabled="disabled"></td>
				

				<td><input type="text" value=1></td>
				<td><input type="text" name="source" id="source"
					value="<c:out value="${current.first_class_reserved*100}"/>" disabled="disabled">$</td>
				
			</tr>
			
			</c:forEach>
			<tr>
				<td colspan="6">Total</td>
				<td><input type="text" name="total" id="total" value="<c:out value="${sessionScope.sum}"/>" disabled='true' > </td>
			</tr>
		</table>
	</div>
	<form action="TransactionConfirmation" method="post">
		<div align="center" id="details">
			<table>

				<tr>
					<td>Account no</td>
					<td><input type="text" id="acno" name="acno"></td>
				</tr>
				<tr>
					<td>Holder ID</td>
					<td><input type="text" id="holder" name="acctname"></td>
				</tr>
				<tr>
					<td>Routing Number</td>
					<td><input type="text" id="rtng" name="rtngno"></td>
				</tr>

				<tr>
					<td colspan="2"><input class="info1"  type="button"
						value="Confirm" id="action"></td>
					<td colspan="1"><input class="info" type="button"
						value="Cancel" onclick="location='flightsearchquery.jsp'"></td>
				</tr>
	<tr ><div id="loading">LOADING.......</div></tr>
	
		</div>
		<tr ><div id="conforming">CONFIRMING.......</div></tr>
			</table>
		</div>
	</form>
<div align="center" id="proceed">
</div>
<div align="center" id="print">

</div>
</body>
</html>