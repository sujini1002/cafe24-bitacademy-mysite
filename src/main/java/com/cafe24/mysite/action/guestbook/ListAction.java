package com.cafe24.mysite.action.guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caf24.mysite.dao.GuestBookDao;
import com.cafe24.mysite.vo.GuestBookVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class ListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> list = dao.getList();
		//Map형식으로 request에 값 저장
		request.setAttribute("list", list);
		// list action (다른 값이 들어노는 경우 list로 처리)
		WebUtil.forward(request, response, "/WEB-INF/views/guestbook/list.jsp");

	}
}
