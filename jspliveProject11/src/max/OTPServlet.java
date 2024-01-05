package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.bo.OTPServices;
import max.dao.OTPDAO;


@WebServlet("/OTPServlet")
public class OTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String mobile= request.getParameter("phone");
		
		OTPServices oTPServices=new OTPServices();
		String otp = oTPServices.generateOTP(mobile);
		
		OTPDAO oTPDAO=new OTPDAO();
		
		int ot=oTPDAO.getOTP(mobile, Integer.parseInt(otp));
		out.println(ot);
	}

}
