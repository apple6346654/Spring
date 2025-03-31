package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){ //Model를 활용해서 데이터를 View로 넘길 수 있음~
        model.addAttribute("data", "Hello World!");
        return "hello";
    }
}
