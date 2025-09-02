package com.ohgiraffers.lifecycle.section02.annotation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(value = "/annotation-lifecycle", loadOnStartup = 2)    // 개발하기 쉽다 | 한번에 매핑 정보를 보기 어렵다
public class LifeCycleTestServlet extends HttpServlet {
    /* 설명. 기본 생성자 */
    public LifeCycleTestServlet() {
        System.out.println("annotation 방식 서블릿 기본 생성자 실행!!");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
        System.out.println("annotation 매핑 init() 메소드 호출");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
        System.out.println("annotation 매핑 service() 호출");
    }

    @Override
    public void destroy() {
//        super.destroy();
        System.out.println("annotation 매핑 destroy() 메소드 호출");
    }

}
