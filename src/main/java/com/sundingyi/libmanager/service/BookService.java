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
    
    public Book getById(long id) {
        Book book = bookDao.selectByPrimaryKey(id);
        return book;
    }
    
    public void updateById(Book book) {
        Book oldBook = bookDao.selectByPrimaryKey(book.getId());
        book.setBorrowed(oldBook.getBorrowed());
        book.setBorrowedTo(oldBook.getBorrowedTo());
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andIdEqualTo(book.getId());
        bookDao.updateByExample(book, bookExample);
    }
    
    public void updateByIdBorrow(Book book) {
        Book oldBook = bookDao.selectByPrimaryKey(book.getId());
        book.setBookname(oldBook.getBookname());
        book.setAuthor(oldBook.getAuthor());
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andIdEqualTo(book.getId());
        bookDao.updateByExample(book, bookExample);
    }
}
