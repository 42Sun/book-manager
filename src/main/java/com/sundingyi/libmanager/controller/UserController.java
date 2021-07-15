package com.sundingyi.libmanager.controller;

import com.sundingyi.libmanager.model.User;
import com.sundingyi.libmanager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/create")
    public String create() {
        return null;
    }
    
    @GetMapping()
    public String user(Model model) {
        List<User> userList = new ArrayList<>();
        userList = userService.getUsers();
        model.addAttribute("userList", userList);
        return "user";
    }
    
    @PostMapping("/create")
    public String create(int a) {
        return null;
    }
}
