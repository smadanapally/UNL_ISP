<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViSiriFlights Registration</title>
<script type="text/javascript">
	function validateForm() {
		//alert('in validateForm()')

		//var iChars = "0123456789!@#$%^&*()+=-[]\\\';,./{}|\:<>?";
		//var iChars1 = "abcdefghijklmnopqrstuvwxyz!@#$%^&*()+=-[]\\\';,./{}|\:<>?";
		var userid= document.getElementsByName("userId")[0].value;
		var email= document.getElementsByName("emailadd")[0].value;
		var date= document.getElementsByName("dob")[0].value;
		var usrname=document.getElementsByName("uname")[0].value;
		var pass1 = document.getElementsByName("password")[0].value;
		var pass2 = document.getElementsByName("rpassword")[0].value;
		var atpos = email.indexOf("@");
	    var dotpos = email.lastIndexOf(".");
	   // alert('in validateForm() 2')
	    if(userid==null || userid=="")
	    	{
	    	alert('Please enter userid');
	    	return false;
	    	}
	   if(usrname==null||usrname=="")
		   {
		   alert('please enter the full name');
		   return false;
		   }
	    if(email == null || email=="")
	    	{
	    	alert('Please enter email address');
	    	return false;
	    	}
	    if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=x.length) {
	        alert('Not a valid e-mail address');
	        return false;
	    }
		if ((pass1 == "") || (pass2 == "")) {
			alert('Please enter password');
			return false;
		}
		if (pass1 != pass2) {
			alert('Passwords don\'t match');
			return false;
		}
		
		return true;
	}
</script>
<style type="text/css">
html {
background: url(flight.jpg) no-repeat center center fixed;
-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	position:relative;
}
.display input[type="submit"]{
background:#6699FF;
border: 1px solid #ffffff;
	border-radius: 15px;
	-moz-border-radius: 15px;
	-webkit-border-radius: 15px;
  -ms-border-radius: 15px;
  -o-border-radius: 15px;
	color: #fff;
	font-weight: bold;
	line-height: 40px;
	text-align: center;
	text-transform: uppercase;
	width: 180px;
}

div {
	padding-top: 150px;
}

h1 {
	width: 270px;
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
		
input{

display: block;
  width: 100%;
  height: 38px;
  margin-top: 2px;
  font-weight: 500;
  background: none;
  border: 0;
  border-bottom: 1px solid #d8d8d8;
}
</style>
<script src="./js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="./js/picker.js" type="text/javascript"></script>
<script src="./js/picker.date.js" type="text/javascript"></script>
<script src="./js/picker.time.js" type="text/javascript"></script>
<script src="./js/legacy.js" type="text/javascript"></script>
<script src="./js/datescript.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="./css/default.css"/>
<link rel="stylesheet" type="text/css" href="./css/default.date.css"/>
<link rel="stylesheet" type="text/css" href="./css/default.time.css"/>
</head>
<body>

	<div id="registerr" align="center" class="display">
		<form id="register" action="Registration"
			onSubmit="return validateForm()" method="post">
			<table>
				<tr>
					<th colspan="2"><h1 class="register-title">Welcome</h1></th>
				</tr>
				<tr>
					<td>UserId</td>
					<td><input type="text" class="register-input"
						placeholder="enter desired userid" name="userId"></td>
				</tr>
				<tr>
					<td>Email-Address</td>
					<td><input type="text" class="register-input"
						placeholder="enter a valid email-address" name="emailadd"></td>
				</tr>
				<tr>
					<td>Full Name</td>
					<td><input type="text" class="register-input"
						placeholder="Leave empty if personal" name="uname"></td>
				</tr>
				<tr>
					<td>Organization</td>
					<td><input type="text" class="register-input"
						placeholder="Leave empty if personal" name="org"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" class="register-input"
						placeholder="Leave empty if personal" name="addr"></td>
				</tr>
				<tr>
					<td>Date-of-Birth</td>
					<td><input type="text" placeholder="yyyy-mm-dd" class="datepicker" name="dob" id="dob" style="width: 170px;">
			</td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" class="register-input"
						placeholder="Type password" name="password"></td>
				</tr>
				<tr>
					<td>Re Password</td>
					<td><input type="password" class="register-input"
						placeholder="Confirm Password" name="rpassword"></td>
				</tr>
				<tr></tr>
				<tr>
					<td align="center" colspan="2"><input type="submit"
						value="Create Account" class="register-button"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>