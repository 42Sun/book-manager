package com.sundingyi.libmanager.controller;

import com.github.pagehelper.PageInfo;
import com.sundingyi.libmanager.model.Book;
import com.sundingyi.libmanager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    private final BookService bookService;
    
    public IndexController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(value = "page", defaultValue = "1") int page) {
        PageInfo<Book> bookPageInfo = bookService.getAllBooks(page, 8);
        model.addAttribute("bookPageInfo", bookPageInfo);
        model.addAttribute("Page", true);
        return "index";
    }
    
    @GetMapping("/unauth")
    public String unauth() {
        return "unauth";
    }
}
