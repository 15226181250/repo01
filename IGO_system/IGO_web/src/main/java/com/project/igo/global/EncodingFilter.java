package com.project.igo.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    //指定过滤器默认编码为utf-8
    private String encoding = "utf-8";
    //指定初始化方法,如果请求中没有指定encoding的值,则按照过滤器指定默认编码
    public void init(FilterConfig filterConfig) throws ServletException {
        if(filterConfig.getInitParameter("encoding")!=null){
            encoding = filterConfig.getInitParameter("encoding");
        }
    }
    //指定过滤方法
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将请求和响应强制转换为HttpServletRequest和HttpServletResponse
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //将请求响应中的字符集编码设置为utf-8
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        //调用拦截器链让该方法继续执行
        filterChain.doFilter(request,response);
    }

    public void destroy() {
    }
}