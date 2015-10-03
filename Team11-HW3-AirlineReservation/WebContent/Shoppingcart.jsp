<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="beans.Flight,java.util.ArrayList,java.text.SimpleDateFormat"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
html {
	background: url(flight.jpg) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	position: relative;
	font-family: 'Open Sans', Helvetica, sans-serif;
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
</style>
<link rel="stylesheet" type="text/css" href="./css/default.css" />
<link rel="stylesheet" type="text/css" href="./css/default.date.css" />
<link rel="stylesheet" type="text/css" href="./css/default.time.css" />
<link rel="stylesheet" type="text/css" href="./css/menustyle.css" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
$('.removebutton').on('click', function () {
	// <-- changes
	
    if(confirm("Are you sure you want to remove"))
    {
    $(this).parent().parent().remove();
    	$.get("Shoppingcart",
    		  {
    	"element":$(this).attr('id')
    	},
      function(data, status){
    	  var b=<%=(Integer)request.getSession().getAttribute("sum")%>
    	  alert(b);
    	  alert('data'+data);
    	  $(this).parent().parent().remove();
    	  var a=$.session.get('sum');
    	  System.out.println(a);
    	  $('#total').text(data);
       });
    console.log("VS");	
    return false;
    }
});

$('.Test').on('click', function () {
	// <-- changes
	
	$('#totaldiv').text(10);
   
});

});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>

<div id='cssmenu'>
		<ul>
			<li><a href='#'>Welcome  <c:out value="${username}" />  From: <c:out value="${organization}" /> </a></li>
			<li style="float: right"><a
				href="Logout">Logout</a></li>
			

		</ul>
	</div>
<div align="center">
	<table id='List'>
		<tr>
			<th>Flight Number</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Number of Seats</th>
			<th>Departure Date</th>
			<th>No of Stops</th>
			<th>Cost</th>
		</tr>


	<c:forEach items="${sessionScope.Shopping}" var="current">

		<tr>
			<td><c:out value="${current.flightno}" /></td>
			<td><c:out value="${current.source}" /></td>
			<td><c:out value="${current.destination}" /></td>
			<td><c:out value="${current.first_class_reserved}" /></td>
			<td><c:out value="${current.departure}" /></td>

			<td>1</td>
			<td class='price'><c:out value="${current.first_class_reserved*100}" /></td>
			
			
			<td><input class='removebutton' type="Button" id=<c:out value="${current.flightno}"/>
				name='remove' value='Remove'></td>
		</tr>
	

</c:forEach>

		<tr>
			
			<td colspan="4">Total Cost:<input type="text" id="total" value="<c:out value="${sessionScope.sum}"/>" disabled=true>
		
			</td>
		</tr>

		<tr>
		<tr>
			<td colspan="4"><input type="button" value="Continue Shopping"
				onclick="location='flightsearchquery.jsp'"></td>
			<td colspan="3"><input type="button" value="Checkout" onclick="location='Transaction.jsp'"></td>
		</tr>
	</table>
	</div>
</body>
</html>