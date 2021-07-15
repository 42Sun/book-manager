package com.sundingyi.libmanager.controller;

import com.sundingyi.libmanager.model.Book;
import com.sundingyi.libmanager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PublishController {
    private final BookService bookService;
    
    public PublishController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/publish") //新图书
    public String publish() {
        return "publish";
    }
    
    @GetMapping("/publish/{id}") //修改页面
    public String publish(@PathVariable("id") long id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("bookname", book.getBookname());
        model.addAttribute("author", book.getAuthor());
        model.addAttribute("borrowed", book.getBorrowed());
        model.addAttribute("borrowed_to", book.getBorrowedTo());
        return "publish";
    }
    
    @PostMapping("/publish/{id}") //图书修改信息传回
    public String publich(@PathVariable("id") long id,
                          @RequestParam("bookname") String bookname,
                          @RequestParam("author") String author) {
        Book book = new Book();
        book.setId(id);
        book.setBookname(bookname);
        book.setAuthor(author);
        bookService.updateById(book);
        return "redirect:/book/" + id;
    }
}
