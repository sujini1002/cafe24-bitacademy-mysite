package com.cafe24.mysite.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCircleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init();
//		Map map = new HashMap();//request,session
//		getServletContext().setAttribute("cacheUser", map);//contextPath를 사용할 수 있는 모든 범위에서 접근가능 == 전역 , 동기화가 중요
		System.out.println("init() called");
	}

	public void destroy() {
		System.out.println("destroy() called");
		super.destroy();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() called");
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() called");
		
		response.getWriter().println("<h1>Servlet life Circle</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() called");
	}

	

	

}
