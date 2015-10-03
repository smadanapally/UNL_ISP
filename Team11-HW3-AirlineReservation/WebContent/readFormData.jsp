<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="beans.Flight,java.util.ArrayList,java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<Flight> temp=(ArrayList<Flight>)request.getSession().getAttribute("flightdetails");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
int index=(Integer)request.getSession().getAttribute("index");
int notickets=Integer.parseInt(request.getParameter("number"));
Flight f1=new Flight();
f1=temp.get(index);
f1.setFirst_class_reserved(notickets);

int sum=(Integer)(request.getSession().getAttribute("sum"));
sum+=notickets*100;
request.getSession().setAttribute("sum", sum);
ArrayList<Flight> shpng=(ArrayList<Flight>) request.getSession().getAttribute("Shopping");
shpng.add(f1);

request.getSession().setAttribute("Shopping", shpng);
%>
The Flight booking has been added to your shopping cart.
sum=<%=(Integer)(request.getSession().getAttribute("sum")) %>
</body>
</html>