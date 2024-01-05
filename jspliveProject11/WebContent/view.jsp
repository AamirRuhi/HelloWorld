<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="max.dto.ChildDTO" %>
    <%@ page import="max.dto.FatherDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="3" bgcolor="cyan">
<%
List<ChildDTO> cl=(List<ChildDTO>)request.getAttribute("c");
List<FatherDTO> fl=(List<FatherDTO>)request.getAttribute("f");
   for(FatherDTO f:fl)
   {
%>
<tr><td>fid</td><td>name</td><td>gndr</td><td>1</td><td>1</td><td>1</td></tr>

<tr><td><%=f.getFid() %></td><td><%=f.getName() %></td><td><%=f.getGndr() %></td><td><%=f.getDob() %></td><td><%=f.getStName() %></td><td><%=f.getDistName() %></td></tr>
 <tr><td colspan="6">Child Details</td></tr>
     <%
    
    for(ChildDTO c:cl)
    {
    	
      if(c.getFid()==f.getFid())
      {
   %>
   
   
   <tr><td><%=c.getAdhar() %></td><td><%=c.getAge() %></td><td><%=c.getCid()%></td><td><%=c.getFid() %></td><td><%=c.getName() %></td></tr>
  
  <% 
   }
      }
    } 
    %>



</table>



</body>
</html>