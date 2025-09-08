package com.ohgiraffers.chap02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodMappingTestController {

    /* 설명. 핸들러 메소드는 어노테이션으로 요청을 매핑하고 반환하는 문자열로 view를 선택한다. */
//    @RequestMapping(value="menu/regist", mehod = RequestMethod.GET) // Get 요청만 받음
    @RequestMapping(value="menu/regist")                            // Get 요청 뿐 아니라 다른 요청도 받을 수 있음
//    public String registMenu() {
    public String registMenu(Model model) { // request의 attribute에 담았듯이 사용
        System.out.println("/menu/regist 경로의 요청 받아보기");

        model.addAttribute("message", "신규 메뉴 등록된 헨들러 메소드 호출함...");

        return "mappingResult";  // view의 이름(view가 될 html의 이름) -> forward가 일어남
    }

    @RequestMapping(value = "menu/modify", method = RequestMethod.POST)
    public String modifyMenu(Model model) {
        model.addAttribute("message", "POST 방식의 메뉴 수정용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    @GetMapping("/menu/delete")
    public String GetDeleteMenu(Model model) {
        model.addAttribute("message", "GET 방식의 메뉴 삭제용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    @PostMapping("menu/delete")
    public String postDeleteMenu(Model model) {
        model.addAttribute("message", "POST 방식의 메뉴 삭제용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

}
