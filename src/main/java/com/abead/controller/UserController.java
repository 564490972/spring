package com.abead.controller;

import com.abead.db.mapper.UserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.abead.model.LoginLog;
import com.abead.services.UserService;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {
	   @Autowired
       private UserService userService;
	   
	   @RequestMapping("/total")
	   public String get(){
		   WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		   ServletContext servletContext =  applicationContext.getServletContext();
		   WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		   WebApplicationContext w = (WebApplicationContext)servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		   WebApplicationContext wac=WebApplicationContextUtils.
				   getWebApplicationContext(servletContext,
						   "org.springframework.web.servlet.FrameworkServlet.CONTEXT.DispatcherServlet" );
		   System.out.println(applicationContext == wc);
		   System.out.println(applicationContext == w);
		   System.out.println(wac == w);
		   UserLoginMapper userLoginMapper = (UserLoginMapper)applicationContext.getBean("userLoginMapper");
		   UserService userService = (UserService)wc.getBean("userService");
		   UserController userController = (UserController)wac.getBean("userController");
		   LoginLog log = new LoginLog();
		   log.setIp("101.37.33.38");
		   log.setLastAddress("北京");
		   log.setLastDate("2017-06-03");
		   userService.update(log);
		   return "index";
	   }
}
