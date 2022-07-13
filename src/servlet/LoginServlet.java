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
		String verifycode=request.getParameter("verifycode");//从浏览器表单中获取到的验证码字符串
		//验证码校验
		String checkcode=(String)session.getAttribute("CHECKCODE_SERVER");//从session中获取服务器端生成的验证码字符串
		if(!checkcode.equalsIgnoreCase(verifycode))//两个验证码不一致
		{
			//提示信息验证码错误
			request.setAttribute("login_msg", "验证码错误!!!!!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//验证码正确
		 * 
		 */
		//封装浏览器端传来的用户数据为一个用户对象loginUser
		Administrator loginUser=new Administrator();
		loginUser.setAdname(adname);
		loginUser.setAdpasswd(adpasswd);
		//调用UserDao中的方法查询数据库
		AdministratorDao userdao=new AdministratorDao();
		Administrator user=userdao.login(loginUser);//ad对象是从数据库中查询的带全字段的用户对象
		//判断查询是否成功
		if(user==null) {
			//查询失败，用户不存在，提示用户名或密码错误
			request.setAttribute("login_msg", "LOGIN_ERROR");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {
			//查询成功
			session.setAttribute("user", user);//把ad对象的数据存到session中，便于其他页面访问和使用
			request.getRequestDispatcher("/variable.jsp").forward(request, response);
			
		}	
	}
}
