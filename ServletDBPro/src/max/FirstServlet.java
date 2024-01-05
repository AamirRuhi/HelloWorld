package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ok")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		int uid = Integer.parseInt(request.getParameter("uid"));
		String add = request.getParameter("add");
		Emp e=new Emp();
		e.setAdd(add);
		e.setName(name);
		e.setUid(uid);
		EmpDAO empDAO=new EmpDAO();
	if(empDAO.insertDetail(e)) {
		out.println("success");
	}else {
		System.out.println("DB erro");
	}
	}

}
