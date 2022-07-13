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
 * Servlet implementation class AddVariableServlet
 */
@WebServlet("/addVariableServlet")
public class AddVariableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddVariableServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取浏览器传入信息，并封装为一个Variable对象(通过Map集合一次获取，获得所有参数都是String类型)
		Map<String,String[]> map=request.getParameterMap();
		Variable variable=new Variable();
		//通过BeanUtils将Map集合中数据快速封装到Variable对象中
		try {
			BeanUtils.populate(variable, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VariableDao variableDao=new VariableDao();
		variableDao.addVariable(variable);
		response.sendRedirect(request.getContextPath()+"/findVariableByPageServlet");
	}

}
