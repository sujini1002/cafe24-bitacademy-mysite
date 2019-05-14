package com.cafe24.mysite.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// coookie test
		int count = 0;
		
		//쿠키 읽기
		Cookie[] cookies = request.getCookies();
		if(cookies!=null && cookies.length>0) {
			for(Cookie c : cookies){
				if("vsitCount".equals(c.getName())) {
					count = Integer.parseInt(c.getValue());
				}
			}
		}
		//쿠키쓰기
		count++;
		Cookie cookie = new Cookie("visitCount",String.valueOf(count));
		cookie.setMaxAge(60*60*24);//하루 셋팅
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		
		
		WebUtil.forward(request, response, "WEB-INF/views/main/index.jsp");
	}

}