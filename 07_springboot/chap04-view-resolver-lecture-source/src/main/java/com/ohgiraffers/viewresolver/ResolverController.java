package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResolverController {

    /* 설명.
     *  ViewResolver(뷰리졸버): 인터페이스를 구현한 ThymeleafViewResolver가 현채 처리하게 된다.
     *  접두사(prefix): classpath:/templates/
     *  접두사(suffix): .html
     *  핸들러 메소드가 반환하는 문자열은 뷰리조러로 향하게 되고 'redirect:' 가 들어간 문자열의 경우에는 접두사와 접미사 추가 X
     * */
    @GetMapping("/string")
    public String stringReturning(Model model) {
        model.addAttribute("forwardMessage", "문자열로 뷰이름 반환함...");
        return "result";
    }

    @GetMapping("/string-redirect")
    public String stringRedirect(Model model) {
        /* 설명. redirect 되어 요청이 다시 왔을 때 응답되는 view의 재료로 담는 걸 시도(model에 담긴 걸로는 전달 X) */ // 유지 안됨
        model.addAttribute("message1", "문자열로 뷰 이름 반환하며 리다이렉트"); // 리다이렉트시 소실

        return "redirect:/";
    }

    @GetMapping("/string-redirect-attr")
    public String stringRedirectFlashAttr(RedirectAttributes rttr) {

        /* 설명. 스프링부트에서는 리다이렉트 시에 값이 전달되게 하고 싶다면 RedirectAttributes에 Flash Attribute로 추가한다. */
        /* 설명. 추가로 내부적으로 HttpSession을 활용하기 때문에 Flash Attribute의 키 값이 기존 session의 키 값과 중복되면 X */
        rttr.addFlashAttribute("flashMessage1", "문자열로 뷰 이름 반환하여 리다이렉트");

        return "redirect:/";
    }


    /* 설명. forward 시에는 Model에 재료를, redirect 시에는 RedirectAttributes에 재료를 담는다. */

    @GetMapping("/modelandview")
    public ModelAndView modelAndViewTest(ModelAndView mv) {
        mv.addObject("forwardMessage", "ModelAndView를 이용한 forward");
        mv.setViewName("result");

        return mv;
    }

    @GetMapping("/modelandview-redirect")
    public ModelAndView modelAndViewRedirect(ModelAndView mv) {
        
        /* 설명. url 경로 상에 Query String 형태로 파라미터로 넘어간다. */
        mv.addObject("message2", "ModelAndView를 이용한 redirect"); // 파라미터로 넘어감(queryString) -> 새로고침 시 유지
        mv.setViewName("redirect:/");
        return mv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView modelAndViewRedirectFlashAttr(ModelAndView mv, RedirectAttributes rttr) {
        rttr.addFlashAttribute("flashmessage2", "ModelAndView를 이용한 redirect attr");
        mv.setViewName("redirect:/");

        return mv;
    }
}
