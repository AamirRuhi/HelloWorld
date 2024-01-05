package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import max.dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		String pass = request.getParameter("pass");
		String mobile = request.getParameter("mob");
		String otp = request.getParameter("otp");
		
		LoginDAO loginDAO=new LoginDAO();
		
		String st = loginDAO.login(uid,pass,mobile,Integer.parseInt(otp));
		if(st.equalsIgnoreCase("WelCome"))
		{
			HttpSession s = request.getSession();
			s.setAttribute("uid", uid);
			request.getRequestDispatcher("Wel.jsp").forward(request, response);
		}
		
		
		out.println("Result "+st);
	}

}
