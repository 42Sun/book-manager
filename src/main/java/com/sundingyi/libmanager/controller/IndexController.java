package com.sundingyi.libmanager.controller;

import com.sundingyi.libmanager.model.Book;
import com.sundingyi.libmanager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    private final BookService bookService;
    
    public IndexController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/")
    public String index(Model model) {
        List<Book> bookList = new ArrayList<>();
        bookList = bookService.getAllBooks();
        model.addAttribute("bookList", bookList);
        return "index";
    }
    
    @GetMapping("/unauth")
    public String unauth() {
        return "unauth";
    }
}
