package com.sundingyi.libmanager.controller;

import com.sundingyi.libmanager.service.BookService;
import com.sundingyi.libmanager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class DeleteController {
    
    private final BookService bookService;
    private final UserService userService;
    
    public DeleteController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }
    
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        bookService.deleteById(id);
        return "redirect:/";
    }
    
    @GetMapping("/delete/user/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        userService.deleteByUsername(username);
        return "redirect:/";
    }
}
