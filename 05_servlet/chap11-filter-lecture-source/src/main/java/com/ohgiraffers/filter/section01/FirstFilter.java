package com.ohgiraffers.filter.section01;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "firstFilter")
@WebFilter(filterName = "firstFilter", urlPatterns = "/first/*")
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        System.out.println("FirstFilter 인스턴스 생성");
    }


    // 서블릿 가기 전에 호출
    // 전처리뿐 아니라 서블릿으로 가는것을 막을 수도 있음
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FirstFilter의 doFilter() 호출 됨...");
        /* 설명. FilterChain에서 제공하는 doFilter를 통해 다음 필터 또는 서블릿으로 진행하라는 의미이다. */
        chain.doFilter(request, response);  // 다음 필터가 있으면 다음 필터로 가고 없으면 서블릿으로 가라 -> 이게 없으면 서블릿으로 안감 -> 필터를 통해 서블릿으로 가면 안되는 것을 막음(유효성 검사)
        System.out.println("First: 서블릿 다녀온 이후 client로 응답 전");
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
        System.out.println("FirstFilter 삭제 직전!");
    }
}
