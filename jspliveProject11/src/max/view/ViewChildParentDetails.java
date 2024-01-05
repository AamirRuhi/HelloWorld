package max.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.dao.ParentsDAO;
import max.dto.ChildDTO;
import max.dto.FatherDTO;

/**
 * Servlet implementation class ViewChildParentDetails
 */
@WebServlet("/ViewChildParentDetails")
public class ViewChildParentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParentsDAO pdao=new ParentsDAO();
		Map<String, Object> m = pdao.viewdetails();
		List<ChildDTO>  clst=(ArrayList<ChildDTO> )m.get("clst");
		List<FatherDTO>  flst=(ArrayList<FatherDTO> )m.get("flst");
		
		request.setAttribute("f", flst);
		request.setAttribute("c", clst);
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

}
