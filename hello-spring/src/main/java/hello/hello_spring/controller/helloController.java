package hello.hello_spring.controller;


import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class helloController {


    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello-template";
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("data", name);
        return "hello-template.html";
    }


}
