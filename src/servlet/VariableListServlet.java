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
		//��ѯ���ݿ���variable�����������ݣ�����Variabledao���в�ѯ������ѯ
		//findvariable,����һ���û���Ϣ�ļ���
		VariableDao variabledao=new VariableDao();
		List<Variable> variables=variabledao.findAllVariable();
		//����ѯ����variables�������ݴ���request�У���list.jspʹ��
		request.setAttribute("variables", variables);
		//�ض���variable.jspҳ��
		request.getRequestDispatcher("variable.jsp").forward(request, response);
	}

}
