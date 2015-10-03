$(document).ready(function(){
	function validateForm() {
		alert('in validateForm()')

		//var iChars = "0123456789!@#$%^&*()+=-[]\\\';,./{}|\:<>?";
		//var iChars1 = "abcdefghijklmnopqrstuvwxyz!@#$%^&*()+=-[]\\\';,./{}|\:<>?";
		var userid= document.getElementsByName("userId")[0].value;
		var email= document.getElementsByName("emailadd")[0].value;
		var date= document.getElementsByName("dob")[0].value;
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

	$('.datepicker').pickadate(
			{
				selectMonths: true,
				selectYears: true,
				format: 'yyyy-mm-dd',
				formatSubmit: 'yyyy-mm-dd'
			
			});
});