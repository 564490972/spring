package com.abead.controller;

import com.abead.db.mapper.UserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.abead.model.LoginLog;
import com.abead.services.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/testRequestParm", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<LoginLog> testRequestParm(HttpServletRequest request, @RequestParam(value = "parm", required = false, defaultValue = "0") int pa) {
        System.out.println(request.getContextPath());
        System.out.println(pa);
        return userService.selectAll();
    }

    @RequestMapping("/total")
    public String get() {
        WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = applicationContext.getServletContext();
        WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        WebApplicationContext w = (WebApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        WebApplicationContext wac = WebApplicationContextUtils.
                getWebApplicationContext(servletContext,
                        "org.springframework.web.servlet.FrameworkServlet.CONTEXT.DispatcherServlet");
        System.out.println(applicationContext == wc);
        System.out.println(applicationContext == w);
        System.out.println(wac == w);
        UserLoginMapper userLoginMapper = (UserLoginMapper) applicationContext.getBean("userLoginMapper");
        UserService userService = (UserService) wc.getBean("userService");
        UserController userController = (UserController) wac.getBean("userController");
        UserController userController2 = (UserController) applicationContext.getBean("userController");
        CommonsMultipartResolver multipartResolver = (CommonsMultipartResolver) wac.getBean("multipartResolver");
        UserLoginMapper userLoginMapper1 = (UserLoginMapper) wac.getBean("userLoginMapper");
        UserService userService1 = (UserService) wac.getBean("userService");
        LoginLog log = new LoginLog();
        log.setIp("101.37.33.38");
        log.setLastAddress("北京");
        log.setLastDate("2017-06-03");
        userService.update(log);
        return "hello";
    }
}
