package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.UserService;
import service.impl.UserServiceImpl;
import domain.User;
import exception.UsersException;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 
		User user = new User();
	
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//调用业务逻辑
		UserService us = new UserServiceImpl();
		User u ;
		
		try {
			u = us.login(user) ;
			
			//分发转向
			if(u!=null)
			{
				//登录成功   将 user 对象放到  seesion 中
				request.getSession().setAttribute("u", user);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else
			{
				
				String msg ="用户名或密码不正确";
				request.setAttribute("msg",msg);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		} catch (UsersException e) {
			e.printStackTrace();
			System.out.println("catch");
			request.setAttribute("msg",e.getMessage());
//			request.getRequestDispatcher("/login.jsp");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
