package com.ohgiraffers.filter.section01;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(filterName = "secondFilter")
@WebFilter(filterName = "secondFilter", urlPatterns = "/*")
public class SecondFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        System.out.println("SecondFilter 인스턴스 생성");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("SecondFilter의 doFilter() 호출 됨..");
        chain.doFilter(request, response);
        System.out.println("Second: 서블릿 다녀온 이후 client로 응답 전");
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
        System.out.println("SecondFilter 삭제 직전");
    }
}
