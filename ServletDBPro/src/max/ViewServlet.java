package max;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		PrintWriter out = response.getWriter();
		EmpDAO empDAO=new EmpDAO();
	 List<Emp> list = empDAO.viewDetail();
	 
	 out.println("<html><body><table border='5' bgcolor='cyan'>");
	 out.println("<tr><td>UID</td><td>Name</td><td>Addr</td></tr>");
	 for( Emp p:list)
	 {
		
out.println("<tr><td>"+p.getUid()+"</td><td>"+p.getName()+"</td><td>"+p.getAdd()+"</td></tr>"); 
	 }
	 
	 out.println("<tr><td><a href=home.html>BACK</a></td></tr>");
	
	 out.println("</table></body></html>");

   	
   	
   	}

}
