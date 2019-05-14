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

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//HttpSession session = request.getSession(true); //최초로 만들때 생성하기위해 true false면 없을 때 null로 리턴
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserVo authUser = new UserDao().get(email, password);
		if(authUser == null) {
			//로그인 실패 알려주기
			request.setAttribute("result", "fail");
			WebUtil.forward(request, response, "/WEB-INF/views/user/loginform.jsp");
			return;//return이 없으면 코드 오류 발생
		}
		//로그인 처리
		HttpSession session = request.getSession();
		session.setAttribute("authUser", authUser);
		
		WebUtil.redirect(request, response, request.getContextPath());
	}

}
