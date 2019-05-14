package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caf24.mysite.dao.UserDao;
import com.cafe24.mysite.vo.UserVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//접근제어
		HttpSession session = request.getSession();
		if (session == null) {
			WebUtil.forward(request, response, request.getContextPath());
			return;
		}
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			WebUtil.forward(request, response, request.getContextPath());
			return;
		}
		
		//no, password,gender
		Long no = Long.parseLong(request.getParameter("no"));
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		UserVo vo = new UserVo();
		vo.setNo(no);
		vo.setPassword(password);
		vo.setGender(gender);
		
		new UserDao().update(vo);
		
		WebUtil.redirect(request, response, request.getContextPath()+"/user?a=updatesuccess");
	}

}
