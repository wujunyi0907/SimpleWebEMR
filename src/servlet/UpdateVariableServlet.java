package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.VariableDao;
import domain.Variable;

/**
 * Servlet implementation class UpdateVariableServlet
 */
@WebServlet("/updateVariableServlet")
public class UpdateVariableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateVariableServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//从浏览器获取数据，map集合封装数据
		Map<String,String[]> map=request.getParameterMap();
		Variable variable=new Variable();
		try {
			BeanUtils.populate(variable, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VariableDao variabledao=new VariableDao();
		variabledao.updateVariable(variable);
		response.sendRedirect(request.getContextPath()+"/findVariableByPageServlet");
	}

}
