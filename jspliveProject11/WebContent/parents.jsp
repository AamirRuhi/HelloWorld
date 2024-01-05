<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="max.dao.LacationDAO" %>
    <%@ page import="java.util.List" %>
    <%@ page import="max.bean.StateBean" %>
    <%@ page import="max.bean.DistBean" %>
    <jsp:useBean id="lacationDAO" class="max.dao.LacationDAO"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script language="javascript">



   function addRow()
   {
   var table=document.getElementById("child");
   var rowCount=table.rows.length;
   var row=table.insertRow(rowCount);
   
   var cell1=row.insertCell(0);
   cell1.innerHTML=rowCount;
   var cell2=row.insertCell(1);
   
   var element2=document.createElement("input");
   element2.type="checkbox";
   element2.name="chk";
   
   cell2.appendChild(element2);
   
   var cell3=row.insertCell(2);
   
   var element3=document.createElement("input");
   element3.type="text";
   element3.name="cname";
   cell3.appendChild(element3);
   
   var cell4=row.insertCell(3);
   
   var element4=document.createElement("input");
   element4.type="text";
   element4.name="age";
   cell4.appendChild(element4);
   var cell5=row.insertCell(4);
   
   var element5=document.createElement("input");
   element5.type="text";
   element5.name="cadhar";
   cell5.appendChild(element5);
   }
   function deleteRow()
   {
     var table=document.getElementById("child");
	 var i=1;
	 if(chkbox==cheked)
	 {
	   table.deleteRow(i);
	   i++;
	 }
	
   }
   
</script>
</head>
<body>
<form action="PServlet" method="post">
<table id="parent" bgcolor="red" border ="3">
<tr>
  <td colspan="4" align="center">Parent's Detail</td>
</tr>
<tr>

<td>Father's Name</td><td><input type="text" name="fname" id="t1"></td></tr>
<tr><td>DOB</td><td><input type="text" name="dob" id="t2"></td>
<td>Gender</td><td><input type="text" name="gender"></td></tr>
<%
  String uid= (String)session.getAttribute("uid");
//String uid="UP_ram123";
StateBean sb=lacationDAO.getStateName(uid.substring(0, 2).toUpperCase());
  List<DistBean> list=lacationDAO.getDistList(sb.getStCode());
%>
<tr><td>State Name</td><td><input type="hidden" name="stCode" value="<%=sb.getStCode()%>"><%=sb.getStName() %></td>
                                 
  


<td>District Name</td>
                      <td><select name="districtCode">
                      
                                   <option value="0">select District</option>
                               <% for(DistBean d:list) 
                               {
                                  %>
                                  
                                  <option value="<%=d.getDistCode()%>"><%=d.getDistName() %></option>
								    <%} %>
								  </select></td>
</tr>


</table>
<table id="child" bgcolor="yellow" border ="3">
  <tr>
   <td colspan="4" align="center">Child's Detail </td><td align="right">
    <input type="button" value="ADD Child" id="b1"  onclick="addRow();">Add Child Detail</button></td>
</tr>
  <tr>
     <td>S.No.</td><td>Select</td><td>Child Name</td><td>Age</td><td>Adhar</td>
  </tr>
  <tr>
     <td>1</td><td><input type="checkbox" name="chk"></td>
     <td><input type="text" name="cname"></td>
     <td><input type="text" name="age"></td>
     <td><input type="text" name="cadhar"></td>
  </tr>
  
</table>
<table>
<tr><td><input type="submit" value="Save"></td>
<td><a href=ViewChildParentDetails>View</a></td>
</tr>
</table>

</form>
</body>
</html>