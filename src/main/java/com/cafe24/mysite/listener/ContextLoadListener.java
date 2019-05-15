package com.cafe24.mysite.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//web.xml에 Listener를 제거하고 어노테이션 사용할 때
//@WebListener 
public class ContextLoadListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent)  { 
		String contextConfigLocation = servletContextEvent.getServletContext().getInitParameter("contextConfigLocation");
		System.out.println("Container starts :"+contextConfigLocation);
	}
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    
	
}
