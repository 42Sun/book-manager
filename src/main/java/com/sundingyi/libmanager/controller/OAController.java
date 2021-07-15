package com.sundingyi.libmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
