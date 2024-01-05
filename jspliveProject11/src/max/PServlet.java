package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.bean.ChildBean;
import max.bean.FatherBean;
import max.dao.ParentsDAO;

@WebServlet("/PServlet")
public class PServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String stCode = request.getParameter("stCode");
		String districtCode = request.getParameter("districtCode");
		FatherBean fb = new FatherBean();
		fb.setDistCode(districtCode);
		fb.setDob(dob);
		fb.setGndr(gender);
		fb.setName(fname);
		fb.setStCode(stCode);
		
		
		String[] cname = request.getParameterValues("cname");
		String[] cadhar = request.getParameterValues("cadhar");
		String[] age = request.getParameterValues("age");
	ChildBean cb = new	ChildBean();
	cb.setAdhar(cadhar);
	cb.setAge(age);
	cb.setName(cname);
	
	ParentsDAO parentsDAO=new ParentsDAO();
		if(parentsDAO.insertParentsDetails(fb, cb))
		{
			out.println("Successsss");
		}
		else
		{
		out.println("failllllll");
		}
	}

}
