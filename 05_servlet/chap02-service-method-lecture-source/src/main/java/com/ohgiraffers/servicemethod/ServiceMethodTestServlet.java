package com.ohgiraffers.servicemethod;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("req = " + req);
        System.out.println("res = " + res);

        /* 설명. Http Method를 확인하기 위해 실제 객체 타입인 HttpServletXXX 계열로 다운캐스팅 후 확인 */
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        String httpMethod = httpRequest.getMethod();    // String으로 HTTP의 요청에 따라서 GET, POST, PUT 중 어느 것인지 반환
        System.out.println("httpMethod = " + httpMethod);

        /* 설명.
         *  기본적으로 쓰는 Http Method 방식
         *  1. GET - 조회
         *  2. POST - 추가
         *  3. PUT / PATCH - 수정(전체 / 부분)
         *  4. DELETE - 삭제
        * */

//        if (httpMethod.equals("GET")) {   // 이 방식은 NPE가 발생할 수 있음
        if ("GET".equals(httpMethod)) {
            doGet(httpRequest, httpResponse);
        } else if ("POST".equals(httpMethod)) {
            doPost(httpRequest, httpResponse);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("GET 요청을 처리할 메소드 호출됨...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("POST 요청을 처리할 메소드 호출됨...");
    }
}
