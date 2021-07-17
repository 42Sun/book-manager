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
public class PublishController {
    private final BookService bookService;
    
    public PublishController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/publish") //新图书
    public String publish(Model model) {
        int NewId = bookService.getMaxId() + 1;
        model.addAttribute("id", NewId);
        return "publish";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/publish/{id}") //修改页面
    public String publish(@PathVariable("id") long id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("id", id);
        model.addAttribute("bookname", book.getBookname());
        model.addAttribute("author", book.getAuthor());
        model.addAttribute("borrowed", book.getBorrowed());
        model.addAttribute("borrowed_to", book.getBorrowedTo());
        return "publish";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/publish/{id}") //图书修改信息传回
    public String publich(@PathVariable("id") long id,
                          @RequestParam("bookname") String bookname,
                          @RequestParam("author") String author) {
        Book book = new Book();
        book.setId(id);
        book.setBookname(bookname);
        book.setAuthor(author);
        bookService.updateById(book);
        return "redirect:/";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/publish/more") // 批量添加
    public String publishMore(Model model) {
        int NewId = bookService.getMaxId() + 1;
        model.addAttribute("id", NewId);
        return "publishmore";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/publish/more/{id}") // POST 批量
    public String publishBackMore(@PathVariable("id") long id,
                                  @RequestParam("bookname") String bookname,
                                  @RequestParam("author") String author,
                                  @RequestParam("amount") long amount,
                                  Model model) {
        if (amount <= 0) {
            model.addAttribute("error", "图书数量不对");
            return "publishmore";
        }
        for (int i = 0; i < amount; i++, id++) {
            Book book = new Book();
            book.setId(id);
            book.setBookname(bookname);
            book.setAuthor(author);
            bookService.updateById(book);
        }
        
        return "redirect:/";
    }
}
