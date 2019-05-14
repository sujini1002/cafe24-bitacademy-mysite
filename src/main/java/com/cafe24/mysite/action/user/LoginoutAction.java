package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite.vo.UserVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class LoginoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//로그아웃
		HttpSession session = request.getSession();
		if(session!=null && session.getAttribute("authUser")!=null ) {
			session.removeAttribute("authUser");
			session.invalidate();//sessionID를 새로 부여 30분후에 사라지지만 메모리 절약을 위해
		}
		
		WebUtil.redirect(request, response, request.getContextPath());
	}

}
