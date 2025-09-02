package com.ohgiraffers.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        /* 설명. HttpServletResponse를 활용해서 서버에서 페이지 만들어 응답 */
        StringBuilder responseTest = new StringBuilder();
        responseTest.append("<!DOCTYPE html>\n")
                    .append("<html>\n")
                    .append("<head>\n")
                    .append("</head>\n")
                    .append("<body>\n")
                    .append("<h1>한글 servlet response</h1>")
                    .append("</body>\n")
                    .append("</html>");

        /* 설명. MIME 타입과 인코딩 방식을 설정해 주어야 한다.
            JakartaEE 이후 생략은 가능하지만 가능한 작성해 주어야 한다. */
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("test/html; charset=UTF=8");    // 한 줄 코딩 가능

        PrintWriter out = resp.getWriter();
        out.print(responseTest);
        out.flush();
        out.close();
    }
}
