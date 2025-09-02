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
        Enumeration<String> keyNames = req.getParameterNames();
        while(keyNames.hasMoreElements()) {
            String key = keyNames.nextElement();
            System.out.println(key);

            String value = req.getParameter(key);
            System.out.println(value);
        }

    }
}
