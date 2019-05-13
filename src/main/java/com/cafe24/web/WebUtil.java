package com.cafe24.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	public static void redirect(HttpServletRequest request, HttpServletResponse response,String url) throws ServletException, IOException{
		response.sendRedirect(url);
	}
	public static void forward(HttpServletRequest request, HttpServletResponse response, String location) throws ServletException, IOException {
		// request 연장 요청
		RequestDispatcher rd = request.getRequestDispatcher(location);
		// 페이지 이동
		rd.forward(request, response);
	}
}
