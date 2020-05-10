package com.houkai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    /**
     * http://localhost:8080/hi
     * @return
     */
    @GetMapping("/hi")
    public String hi(){
        System.out.println("来了,我是攻击者");
        return "Hi";
    }
}
