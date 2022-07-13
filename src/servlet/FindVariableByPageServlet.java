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
		//��ȡҳ�����
		String currentPage_b=request.getParameter("currentPage");//��ǰҳ��
		String rows_b=request.getParameter("rows");//ÿҳ��¼��
		//��ȡ�û���ѯ����
		String varname=request.getParameter("varname");
		if(currentPage_b==null||"".equals(currentPage_b)) {
			//��ǰҳ��Ϊ�ջ�null
			currentPage_b="1";
		}
		if(rows_b==null||"".equals(rows_b)) {
			//��ǰҳ��Ϊ�ջ�null
			rows_b="10";
		}
		//����PageBean����,ʵ��������ֵ
		PageBean<Variable> pageVariable=new PageBean<Variable>();
		//׼���������������
		int currentPage=Integer.parseInt(currentPage_b);//�ַ�����Ϊ����
		int rows=Integer.parseInt(rows_b);
		//��ȡ�����ܼ�¼��
		VariableDao variableDao=new VariableDao();
		int totalCount=variableDao.findTotalCount(varname);
		//������ҳ��
		int totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
		//��װ����Ϊ�б�
		if(currentPage<=0)
			currentPage=1;
		if(currentPage>=totalPage)
			currentPage=totalPage;
		int start=(currentPage-1)*rows;//���㵱ǰҳ��ʼ��¼
		List<Variable> list=variableDao.findVariableByPage(rows, start, varname);
		//ʵ����PageBean����
		pageVariable.setTotalCount(totalCount);
		pageVariable.setRows(rows);
		pageVariable.setTotalPage(totalPage);
		pageVariable.setList(list);
		pageVariable.setCurrentPage(currentPage);
		//pageVariable���빲����
		request.setAttribute("pageVariable", pageVariable);
		request.setAttribute("varname", varname);
		request.getRequestDispatcher("/variable.jsp").forward(request, response);
	}
}
