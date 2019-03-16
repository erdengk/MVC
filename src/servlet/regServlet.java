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

public class regServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 
		User user = new User();
		try {
		BeanUtils.populate(user, request.getParameterMap());
		
		//调用业务逻辑
		UserService us = new UserServiceImpl();
		us.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		response.getWriter().write("注册成功,1s之后回到主页");
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
