package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdministratorDao;
import domain.Administrator;



@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
           }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String adname=request.getParameter("adname");
		String adpasswd=request.getParameter("adpasswd");
		HttpSession session=request.getSession();
		
		/*
		String verifycode=request.getParameter("verifycode");//����������л�ȡ������֤���ַ���
		//��֤��У��
		String checkcode=(String)session.getAttribute("CHECKCODE_SERVER");//��session�л�ȡ�����������ɵ���֤���ַ���
		if(!checkcode.equalsIgnoreCase(verifycode))//������֤�벻һ��
		{
			//��ʾ��Ϣ��֤�����
			request.setAttribute("login_msg", "��֤�����!!!!!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//��֤����ȷ
		 * 
		 */
		//��װ������˴������û�����Ϊһ���û�����loginUser
		Administrator loginUser=new Administrator();
		loginUser.setAdname(adname);
		loginUser.setAdpasswd(adpasswd);
		//����UserDao�еķ�����ѯ���ݿ�
		AdministratorDao userdao=new AdministratorDao();
		Administrator user=userdao.login(loginUser);//ad�����Ǵ����ݿ��в�ѯ�Ĵ�ȫ�ֶε��û�����
		//�жϲ�ѯ�Ƿ�ɹ�
		if(user==null) {
			//��ѯʧ�ܣ��û������ڣ���ʾ�û������������
			request.setAttribute("login_msg", "LOGIN_ERROR");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {
			//��ѯ�ɹ�
			session.setAttribute("user", user);//��ad��������ݴ浽session�У���������ҳ����ʺ�ʹ��
			request.getRequestDispatcher("/variable.jsp").forward(request, response);
			
		}	
	}
}
