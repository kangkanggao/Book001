package com.highlion.servlet.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.highlion.domain.User;
import com.highlion.service.UserService;
import com.highlion.service.impl.UserServiceimpl;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        User user=new User();
		// 1 获取⽤户输⼊
        
		try {
			BeanUtils.populate(user, request.getParameterMap());
			UserService us = new UserServiceimpl();
			us.login(user);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		*/
		String vcode = request.getParameter("vcode");
		// 在查询数据库之前执⾏
		HttpSession session = request.getSession();
		String serverVcode = (String) session.getAttribute("validateCode");
		// 验证码不区分⼤⼩写
		if (!serverVcode.equalsIgnoreCase(vcode)) {
			// 失败
			request.setAttribute("msg", "验证码错误");
			request.setAttribute("name", user.getName());
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		// 2 到数据查询
		UserService us=new UserServiceimpl();
		Boolean ret=us.login(user);
		// 3 给⽤户响应
		if (ret) {
			request.setAttribute("name", user.getName());
			//response.sendRedirect("main.jsp");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			// 失败
			request.setAttribute("msg", "⽤户名或密码错误");
			request.setAttribute("name", user.getName());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}