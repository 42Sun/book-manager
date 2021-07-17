package com.sundingyi.libmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
    @GetMapping("/search")
    public String search() {
        return "search";
    }
    
    @GetMapping("/search/user")
    public String searchUser() {
        return "searchUser";
    }
}
