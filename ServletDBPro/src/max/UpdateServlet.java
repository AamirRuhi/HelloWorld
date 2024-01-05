package max;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		EmpDAO empDAO =new EmpDAO();
		out.println("<html><body>");
		out.println("<form action='updateDetail' method ='get'>");
		out.println("<table boder='3' bgcolor='cyan'>");
		out.println("<tr><td>UID</td>");
		out.println("<td> <select name='uid'>");
		List<Integer> list = empDAO.getUIDList();
		out.println("<option value=0>Select UID</option>");
		for(  Integer p:list) {
			out.println("<option value="+p+">"+p+"</option>");
			
		}
		out.println("</td></tr>");
		out.println("<tr><td><input type='submit' value ='UPDATE'</td></tr>");
		out.println("</table></form></body></html>");
	}

}
