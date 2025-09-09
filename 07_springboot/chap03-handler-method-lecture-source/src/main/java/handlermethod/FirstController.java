package handlermethod;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/first")
public class FirstController {
    /* 설명. 핸들러 메소드에서 반환형이 없을 경우 요청경로를 반환한다.(요청 경로가 곧 view) */
//    @GetMapping("/first/regist")
    @GetMapping("/regist")  // class에 RequestMapping 어노테이션이 들어가면 해당 경로는 스킵하고 작성
//    public String regist() {
//        return "first/regist";
//    }
    public void regist() {}      // 이미 RequestMapping과 GetMapping으로 경로가 있으므로 return 해주지 않아도 됨

    @PostMapping("regist")
    public String registMenu(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        /* 설명. Servlet 계층의 메소드를 호출하며 비즈니스 로직(insert 트랜잭션)을 성공하고 돌아왔다는 가정 */

        /* 설명. insert 성공 메시지와 함께 성공 페이지로 이동 */
        String message = name + "을(를) 신규 메뉴 목록의 "
                        + categoryCode + "번 카테고리에 "
                        + price + "원으로 등록에 성공하였습니다!";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public void modifyMenu() {}

    /* 설명.
     *  request의 parameter로 넘어오는 값들의 key값과 일치하는 변수명(어노테이션 생략가능)을 작성하고 @requestParam
     *  어노테이션을 적용하면 알아서 값ㅇ르 꺼내고 해당 매개변수의 자료형에 맞게 자료형 변환까지 해준다.(물론 가능한 경우)
     *
     * 설명.
     *  1. defaultValue: 사용자의 입력값이 없거나("") 아니면 request의 parameter 키 값과 일치하지 않는
     *                   매개변수 사용 시 배개변수가 가질 기본 default값을 작성한다.
     *  2. name: request parameter의 키 값과 다른 매개변수 명을 사요하고 싶을 때 request parameter의
     *           키 값을 작성한다.
    * */
    @PostMapping("modify1")
//    public String modifyMenu1(Model model, @RequestParam(name = "modifyName") String modifyName, @RequestParam int modifyPrice) {    // 알아서 파싱을 해줌, 원칙은 modifyName 처럼 name 파라미터를 통해 지정하는 것
//    public String modifyMenu1(Model model, String modifyName, int modifyPrice) {    // 파라미터의 name과 동일하게 해서 구분이 되게 했기 때문에 어노테이션을 삭제했어도 정상적으로 동작(@RequestParam 생략 가능)
    public String modifyMenu1(Model model, @RequestParam(name = "modifyName", defaultValue = "디폴트") String modifyName, @RequestParam(defaultValue = "0") int modifyPrice) {    // 사용자가 입력을 안하는 경우에 대한 default 설정이 가능
                                                                                        //넘어온 parameter의 키 값과 일치하며 해당 타입으로 변환 가능하면 @RequestParam 생략 가능

        /* 설명. 넘어온 데이터를 바탕으로 update를 성공했다는 가정 */
        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    /* 설명. @RequestParam을 활용해 하나의 Map으로 받아낼 수 있다. */
    @PostMapping("modify2")
    public String modify2(Model model, @RequestParam Map<String, String> parameterMap) {
        String modifyName = parameterMap.get("modifyName");
        int modifyPrice = Integer.parseInt(parameterMap.get("modifyPrice"));

        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("/search")
    public void search() {}

    @PostMapping("/search")
    public String searchMenu() {

        return "first/messagePrinter";
    }

}
