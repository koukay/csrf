package com.houkai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    /**
     * http://localhost:8081/list
     * @return
     */
    @GetMapping("list")
    public String list(){
        return "list";
    }
    /**
     * http://localhost:8081/update
     * @return
     */
    @GetMapping("update")
    public String update(){
        return "update";
    }
}
