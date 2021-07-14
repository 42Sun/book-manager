package com.sundingyi.libmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "你好";
    }
    
    @ResponseBody
    @GetMapping("/user")
    public String user() {
        return "user";
    }
}
