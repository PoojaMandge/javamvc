package com.clc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class WebXml implements WebApplicationInitializer {
 
    public void onStartup(ServletContext container) throws ServletException {
    	System.out.println("Loading...WebXml");
    	AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringBean.class);
        ctx.setServletContext(container);
        ServletRegistration.Dynamic servlet = container.addServlet("springmvc", new DispatcherServlet(ctx));
   
        
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}

