package com.cafe24.mysite.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.action.guestbook.GuestBookActionFactory;
import com.cafe24.mysite.action.main.MainActionFactory;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("MainServlet:doGetCalled");
//		
//		//한글 깨짐 해결 반드시 .getWriter();위에 있어야 한다. 
//		response.setContentType("text/html; charset=utf-8"); 
//		PrintWriter pw  = response.getWriter(); //이 다음 부턴 body이다.
//		pw.println("<h1>Hello World</h1>");

		String actionName = request.getParameter("a");
		Action action = new MainActionFactory().getAction(actionName);

		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
