<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--h1{Service method}--%>
    <h1>Service method</h1>
    <h3>GET 방식의 요청</h3>
    <h4>a 태그의 href 속성값 변경</h4>
    <a href = "request-service">GET 방식 서비스 요청하기</a>
<%--form에 method를 안적으면 기본 GET방식으로 동작--%>
    <form action = "request-service">
        <button type = "button">GET 방식 요청 버튼</button>
    </form>
    <h3>POST 방식의 요청</h3>
    <h4>form 태크의 method 속성을 post로 설정</h4>
    <form action = "request-service" method = "post">
        <button>POST 방식 요청 버튼</button>
    </form>

</body>
</html>