package com.cafe24.web.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


//web.xml에 있는 filter설정을 어노테이션으로 한것 - 호환성이 떨어짐 web.xml에서 설정하기
//@WebFilter(value="/*", initParams= @WebInitParam(name="encoding",value="utf-8"))
public class EncodingFilter implements Filter {

	private String encoding;
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Encoding Filter initialized......");
		encoding = fConfig.getInitParameter("encoding"); //web.xml에 filter설정에서 inti-param의 param-name을 가져온것
		if(encoding==null) {
			encoding = "utf-8";
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//request 처리
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
		
		//response 처리
	}

	public void destroy() {
	}

}
