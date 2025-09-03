package com.ohgiraffers.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("리다이렉트 이후 request의 attribute 확인: " + req.getAttribute("test"));
        System.out.println("리다이렉트 이후 request의 parameter 확인: " + req.getParameter("test"));
        //리다이렉트 시 req가 새로 생성되기 때문에 servlet의 attribute에 남아 있지 않음
        // get 요청일 경우 get요청이면 url에 queryString(?[key]=[value] & ...)을 남겨야 함
        // 근데 크롬이면 상관없지만 그게 아니라면 queryString 제한 255byte로 넘는지 확인해야 함
        // 많은 정보를 넘겨야 한다면 -> 1. 쿠기 | 2. 서버 세션



    }
}
