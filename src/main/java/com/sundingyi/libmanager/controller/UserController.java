package com.sundingyi.libmanager.controller;

import com.sundingyi.libmanager.model.User;
import com.sundingyi.libmanager.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/user")
@Controller
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }
    
    @GetMapping()
    public String user(Model model) {
        List<User> userList = new ArrayList<>();
        userList = userService.getUsers();
        model.addAttribute("userList", userList);
        return "user";
    }
    
    
    @PostMapping("/create")
    public String createUser(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("roles") String roles,
                             Model model) {
        User user = new User();
        if ("".equals(username) || "".equals(password) || "".equals(roles)) {
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            model.addAttribute("roles", roles);
            model.addAttribute("error", "请不要留空");
            return "modify";
        }
        user.setUsername(username);
        user.setPassword(password);
        user.setRoles(roles);
        userService.insertOrUpdate(user);
        return "redirect:/user";
    }
    
    @GetMapping("/modify/{username}")
    public String modify(@PathVariable("username") String username,
                         Model model) {
        model.addAttribute("username", username);
        return "modify";
    }
    
}
