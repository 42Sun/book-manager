package com.sundingyi.libmanager.controller;

import com.sundingyi.libmanager.model.Book;
import com.sundingyi.libmanager.service.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BorrowController {
    private final BookService bookService;
    
    public BorrowController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/borrow/{id}")
    public String publish(@PathVariable("id") long id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("borrowed", book.getBorrowed());
        model.addAttribute("borrowed_to", book.getBorrowedTo());
        return "borrow";
    }
    
    @PreAuthorize("hasAuthority('BORADMIN')")
    @PostMapping("/borrow/{id}") //图书修改信息传回
    public String publich(@PathVariable("id") long id,
                          @RequestParam("borrowed") Integer borrowed,
                          @RequestParam("borrowed_to") String borrowed_to) {
        Book book = new Book();
        book.setId(id);
        book.setBorrowed(borrowed);
        book.setBorrowedTo(borrowed_to);
        bookService.updateByIdBorrow(book);
        return "redirect:/book/" + id;
    }
}
