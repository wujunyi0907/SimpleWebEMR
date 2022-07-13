package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VariableDao;
import domain.Variable;


@WebServlet("/findVariableServlet")
public class FindVariableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FindVariableServlet() {
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String varid=request.getParameter("varid");
		VariableDao variabledao=new VariableDao();
		Variable variable=variabledao.findVariableById(Integer.parseInt(varid));
		request.setAttribute("variable", variable);
		request.getRequestDispatcher("updateVariable.jsp").forward(request, response);
		
		
	}

}
