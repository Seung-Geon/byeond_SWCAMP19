package com.ohgiraffers.filter.section01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/* 설명.
 *  @WebFilter라는 어노테이션을 통해 필터 설정을 할 수 있지만 요청 시 필터의 동작 순서를
 *  정하기 위해서는 Servlet에서는 web.xml을 통한 설정 시 작성된 순서로만 바꿔줄 수 있다.
 *  (즉, web.xml에 작성된 filter mappping의 순서에 따라 작동)
 *
* */

@WebServlet("/first/filter")
public class FirstFilterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("서블릿으로 get 요청 도착 확인!");
    }
}
