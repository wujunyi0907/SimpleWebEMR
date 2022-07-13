package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VariableDao;
import domain.PageBean;
import domain.Variable;

/**
 * Servlet implementation class FindVariableByPageServlet
 */
@WebServlet("/findVariableByPageServlet")
public class FindVariableByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FindVariableByPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取页码参数
		String currentPage_b=request.getParameter("currentPage");//当前页码
		String rows_b=request.getParameter("rows");//每页记录数
		//获取用户查询条件
		String varname=request.getParameter("varname");
		if(currentPage_b==null||"".equals(currentPage_b)) {
			//当前页码为空或null
			currentPage_b="1";
		}
		if(rows_b==null||"".equals(rows_b)) {
			//当前页码为空或null
			rows_b="10";
		}
		//创建PageBean对象,实例化，赋值
		PageBean<Variable> pageVariable=new PageBean<Variable>();
		//准备对象的属性数据
		int currentPage=Integer.parseInt(currentPage_b);//字符串变为整型
		int rows=Integer.parseInt(rows_b);
		//获取表中总记录数
		VariableDao variableDao=new VariableDao();
		int totalCount=variableDao.findTotalCount(varname);
		//计算总页数
		int totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
		//封装数据为列表
		if(currentPage<=0)
			currentPage=1;
		if(currentPage>=totalPage)
			currentPage=totalPage;
		int start=(currentPage-1)*rows;//计算当前页起始记录
		List<Variable> list=variableDao.findVariableByPage(rows, start, varname);
		//实例化PageBean对象
		pageVariable.setTotalCount(totalCount);
		pageVariable.setRows(rows);
		pageVariable.setTotalPage(totalPage);
		pageVariable.setList(list);
		pageVariable.setCurrentPage(currentPage);
		//pageVariable存入共享域
		request.setAttribute("pageVariable", pageVariable);
		request.setAttribute("varname", varname);
		request.getRequestDispatcher("/variable.jsp").forward(request, response);
	}
}
