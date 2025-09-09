package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController { // 웰컴 페이지만을 위한 Controller 클래스

//    @RequestMapping("/")
//    public String defaultLocation() {
//        return "main";  // -> classpath:/templated/main.html
//    }
//
//    @RequestMapping("/main")
//    public void main() {}

    @RequestMapping(value = {"/", "/main"})
    public String main() {return "main";}
}

