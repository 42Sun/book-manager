package com.sundingyi.libmanager.service;

import com.sundingyi.libmanager.dao.BookDao;
import com.sundingyi.libmanager.model.Book;
import com.sundingyi.libmanager.model.BookExample;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookDao bookDao;
    
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    
    
    public List<Book> getAllBooks() {
        BookExample bookExample = new BookExample();
        List<Book> books = bookDao.selectByExample(bookExample);
        return books;
    }
}
