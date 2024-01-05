<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function getOTP()
{
	
	var mob=document.getElementById("m").value;
	var h;
	if (window.XMLHttpRequest)
	{
	// code for IE7+, Firefox, Chrome, Opera, Safari
	     h=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
	 h=new ActiveXObject("Microsoft.XMLHTTP");
	 }
	 
	 h.onreadystatechange=function()
	{
		
	if (h.readyState==4 && h.status==200)
	{

document.getElementById("t").value=h.responseText;
	}
	 
	}
	 
h.open("GET","OTPServlet?phone="+mob,true);
	h.send();
		
	
	}


</script>
</head>
<body>
 <form action="LoginServlet">
     <table bgcolor="yellow" border="3">
 <tr><td>UID</td><td><input type="text" name="uid"></td></tr>
 <tr><td>Pass</td><td><input type="password" name="pass"></td></tr>
 <tr><td>Mobile</td><td><input type="text" name="mob" size="10" id="m" onblur="getOTP();">
 <input type="text" name="otp" id="t" size="6"></td></tr>
 
 
 
           <tr><td><input type="submit" value="login"></td>
           <td><a href=home.jsp>Registration</a>  </td>
           <td><a href=ViewChildParentDetails>View</a></td></tr>
 
           
           </table>
           
           </form>
           
           
</body>
</html>