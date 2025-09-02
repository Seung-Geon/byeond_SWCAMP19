package com.ohgiraffers.parameter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet("/payload")
public class PayloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);


        /* 설명. tomcat 9버전 이하는 post 요청일 때 인코딩 설정을 하지 않으면 parameter의 한글이 깨질 수 있음 */
//        req.setCharacterEncoding("UTF-8");

        /* 설명. parameter들의 key값들을 한번에 순회하며 파악할 수 있기도 하다.(feat.Enumeration) */
        Enumeration<String> keyNames = req.getParameterNames();
        while(keyNames.hasMoreElements()) {
            String key = keyNames.nextElement();
            System.out.println(key);

            String value = req.getParameter(key);
            System.out.println(value);
        }


    }
}
