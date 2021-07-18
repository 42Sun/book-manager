package com.sundingyi.libmanager.controller;

import com.github.pagehelper.PageInfo;
import com.sundingyi.libmanager.model.Book;
import com.sundingyi.libmanager.model.User;
import com.sundingyi.libmanager.service.BookService;
import com.sundingyi.libmanager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    private final UserService userService;
    private final BookService bookService;
    
    public SearchController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }
    
    @GetMapping("/search")
    
    public String search() {
        return "search";
    }
    
    @PostMapping("/search/user")
    public String searchUser(@RequestParam("username") String username,
                             Model model) {
        List<User> userList = userService.findLikeName(username);
        model.addAttribute("userList", userList);
        return "user";
    }
    
    @PostMapping("/search/book")
    public String searchUser(@RequestParam("bookname") String bookname,
                             @RequestParam("author") String author,
                             Model model) {
        List<Book> bookList = userService.findLikeBook(bookname, author);
        PageInfo<Book> bookPageInfo = new PageInfo<>(bookList);
        model.addAttribute("bookPageInfo", bookPageInfo);
        return "index";
    }
    
    @PostMapping("/search/borrow")
    public String searchBorrow(@RequestParam("username") String username,
                               Model model) {
        PageInfo<Book> bookPageInfo = userService.findBorrowByName(username);
        model.addAttribute("bookPageInfo", bookPageInfo);
        model.addAttribute("noPage", true);
        return "index";
    }
}
