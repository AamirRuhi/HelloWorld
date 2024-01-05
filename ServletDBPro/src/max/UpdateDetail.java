package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateDetail")
public class UpdateDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	 String uid = request.getParameter("uid");
	//out.println("got uid"+uid);
	
	 EmpDAO empDAO=new EmpDAO();
		Emp emp = empDAO.getDetailByUID(Integer.parseInt(uid));
		
		out.println("<html><body>");
		out.println("<form action ='updateEmp' method='get'>");
		out.println("<table border='3' bgcolor='cyan'>");
		out.println("<tr><td>UID</td><td><input type='text' name='uid' readonly='readonly' value='"+emp.getUid()+"'></td></tr>");
		
		out.println("<tr><td>Name</td><td><input type='text' name='name' value='"+emp.getName()+"'></td></tr>");
		out.println("<tr><td>Add</td><td><input type='text' name='add' value='"+emp.getAdd()+"'></td></tr>");
		
		out.println("<tr><td><input type='submit' value='UPDATEEMP'></td></tr>");
		out.println("</table></form></body></html>");
		
	
	}

}
