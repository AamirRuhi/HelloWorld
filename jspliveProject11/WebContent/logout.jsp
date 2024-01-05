<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:useBean id="loginDAO" class="max.dao.LoginDAO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
  String uid=request.getParameter("uid");
   if(loginDAO.logout(uid)>0)
   {    out.println("User Successful logout");
	   request.getRequestDispatcher("login.jsp").include(request, response);
   }
%>

</body>
</html>