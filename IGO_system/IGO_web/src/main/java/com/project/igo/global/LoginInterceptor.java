package com.project.igo.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//设置登录拦截器，强制用户先登录才能进行一系列的请求操作，过滤除出登陆有关以外的所有请求
//拦截器要想生效则必须要去spring_web中进行配置
public class LoginInterceptor implements HandlerInterceptor {
    //该方法用来配置拦截前要做的事情
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//通过httpServletRequest.getRequestURI()获取到当前访问的路径
        String url = httpServletRequest.getRequestURI();
        //先将路径的字符统一转换成小写，判断该路径中是否含有login关键字，因为何登陆有关的操作含有该关键字
        //若indexOf("login")>=0则说明包含该关键字，返回true，可以放行
        if( url.toLowerCase().indexOf("login")>=0 ||
            url.toLowerCase().indexOf("start")>=0 ||
            url.toLowerCase().indexOf("index")>=0 ||
            url.toLowerCase().indexOf("quit")>=0 ||
            url.toLowerCase().indexOf("goods_type")>=0 ||
            url.toLowerCase().indexOf("to_session")>=0 ||
            url.toLowerCase().indexOf("goods_detail")>=0 ||
            url.toLowerCase().indexOf("goods_find")>=0){
            return true;
        }
        //通过判断Session中是否有信息来判断用户是否已经登陆，若Session不为空，则放行
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("user")!=null){
            return true;
        }
        //如果都不满足，则通过httpServletResponse.sendRedirect重定向到登陆界面去登陆
        httpServletResponse.sendRedirect("/to_login");
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
