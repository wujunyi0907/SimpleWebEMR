package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VariableDao;

/**
 * Servlet implementation class DelVariableServlet
 */
@WebServlet("/delVariableServlet")
public class DelVariableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelVariableServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String varid=request.getParameter("varid");
		VariableDao variableDao=new VariableDao();
		variableDao.deleteByVarid(Integer.parseInt(varid));//将String类型的id转换为int型
		//跳转页面
		response.sendRedirect(request.getContextPath()+"/findVariableByPageServlet");
	}

}
