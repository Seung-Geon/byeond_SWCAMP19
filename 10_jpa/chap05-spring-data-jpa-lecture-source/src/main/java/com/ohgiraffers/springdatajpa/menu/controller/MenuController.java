package com.ohgiraffers.springdatajpa.menu.controller;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/menu")
@Slf4j                          // 어노테이션으로 logger 대체
public class MenuController {

    private final MenuService menuService;

    /* 설명.
     *  Logger를 활용한 로그 생성
     *  1. println보다 성능적으로 우수하다.
     *  2. 외부 리소스 파일로 따로 저장 및 송출이 가능하다.
     *  3. 로그레벨에 따른 확인 가능하다.(개발: debug, 서비스: info)
     * */
//    Logger logger = LoggerFactory.getLogger(MenuController.class);
//    Logger logger = LoggerFactory.getLogger(getClass());            // 현재 클래스 알아서 넣어줌


    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /* 설명. url 경로 상에 넘어온 값을 변수에 바로 담을 수 있다.(PathVariable 이라고 한다.) */
    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {
        System.out.println("menuCode = " + menuCode);
//        logger.info("menuCode = {}", menuCode);
        log.debug("menuCode = {}", menuCode);    // 롬복 어노테이션을 이용한 방법

        MenuDTO menu = menuService.findMenuByCode(menuCode);

        model.addAttribute("menu", menu);

        return "menu/detail";
    }

    /* 설명. 페이징 처리 전 */
//    @GetMapping("/list")
//    public String findMenuList(Model model) {
//        List<MenuDTO> menuList = menuService.findMenuList();
//        model.addAttribute("menuList", menuList);
//
//        return "menu/list";
//    }

    /* 설명.
     *  @PageableDefault
     *  1. 기본 한 페이지에 10개의 데이터(size, value)
     *  2. 기본 1페이지부터(0 부터)
     *  3. 기본 오름차순(ASC)
    * */
    /* 설명. 페이징 처리 후 */
    @GetMapping("/list")
    public String findMenuList(@PageableDefault Pageable pageable, Model model) {
        log.debug("pageable: {}", pageable);

        Page<MenuDTO> menuList = menuService.findMenuList(pageable);

        model.addAttribute("menuList", menuList);
        return "menu/list";
        
    }
}

