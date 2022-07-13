package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VariableDao;
import domain.Variable;

/**
 * Servlet implementation class VariableListServlet
 */
@WebServlet("/variableListServlet")
public class VariableListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public VariableListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询数据库中variable表中所有数据，调用Variabledao类中查询方法查询
		//findvariable,返回一个用户信息的集合
		VariableDao variabledao=new VariableDao();
		List<Variable> variables=variabledao.findAllVariable();
		//将查询到的variables集合数据存入request中，供list.jsp使用
		request.setAttribute("variables", variables);
		//重定向到variable.jsp页面
		request.getRequestDispatcher("variable.jsp").forward(request, response);
	}

}
