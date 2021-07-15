package com.sundingyi.libmanager.controller;

import com.sundingyi.libmanager.model.Book;
import com.sundingyi.libmanager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {
    private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/book/{id}")
    public String book(@PathVariable("id") long id, Model model) {
        Book book = bookService.getById(id);
        if (book == null) {
            return "error";
        }
        model.addAttribute("book", book);
        return "book";
    }
}