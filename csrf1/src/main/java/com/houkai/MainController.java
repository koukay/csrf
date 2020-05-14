package com.houkai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login.html")
    public String login(){
        return "login";
    }
    @GetMapping("/ok.html")
    public String ok(){
        return "ok";
    }
}
