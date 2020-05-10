package com.houkai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    /**
     * http://localhost:8081/
     * @return
     */
    @GetMapping
    public String list(){
        return "list";
    }
}
