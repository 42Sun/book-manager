package com.sundingyi.libmanager.controller;

import com.sundingyi.libmanager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteController {
    private final BookService bookService;
    
    public DeleteController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        bookService.deleteById(id);
        return "redirect:/";
    }
}
