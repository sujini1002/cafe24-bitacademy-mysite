package com.cafe24.mysite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caf24.mysite.dao.GuestBookDao;
import com.cafe24.mysite.action.guestbook.GuestBookActionFactory;
import com.cafe24.mysite.vo.GuestBookVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// filter로 옮겨갈 인코딩 부분
//		request.setCharacterEncoding("utf-8");
		String actionName = request.getParameter("a");
		Action action = new GuestBookActionFactory().getAction(actionName);
		
		action.execute(request, response);
		
//		if("add".equals(actionName)) {
//	   		String name = request.getParameter("name");
//	   		String password = request.getParameter("password");
//	   		String contents = request.getParameter("contents");
//	   		
//	   		GuestBookVo vo = new GuestBookVo();
//	   		vo.setName(name);
//	   		vo.setPassword(password);
//	   		vo.setContents(contents);
//	   		
//	   		new GuestBookDao().insert(vo);
//	   		WebUtil.redirect(request, response, request.getContextPath()+"/guestbook");
//			
//		}else if("deleteform".equals(actionName)) {
//			String no = request.getParameter("no");
//			//request에 no값 저장
//			request.setAttribute("no", no);
//			WebUtil.forward(request, response, "/WEB-INF/views/guestbook/deleteform.jsp");
//		}else if("delete".equals(actionName)) {
//			String no = request.getParameter("no");
//			String password = request.getParameter("password");
//			
//			GuestBookVo vo = new GuestBookVo();
//	    	vo.setNo(Long.parseLong(no));
//	    	vo.setPassword(password);
//	    	
//	    	new GuestBookDao().delete(vo);
//	    	WebUtil.redirect(request, response, request.getContextPath()+"/guestbook");
//					
//		}else {
//			GuestBookDao dao = new GuestBookDao();
//			List<GuestBookVo> list = dao.getList();
//			//Map형식으로 request에 값 저장
//			request.setAttribute("list", list);
//			// list action (다른 값이 들어노는 경우 list로 처리)
//			WebUtil.forward(request, response, "/WEB-INF/views/guestbook/list.jsp");
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
