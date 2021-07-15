package com.sundingyi.libmanager.service;

import com.sundingyi.libmanager.dao.BookDao;
import com.sundingyi.libmanager.dao.MyDao;
import com.sundingyi.libmanager.model.Book;
import com.sundingyi.libmanager.model.BookExample;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookDao bookDao;
    private final MyDao myDao;
    
    public BookService(BookDao bookDao, MyDao myDao) {
        this.bookDao = bookDao;
        this.myDao = myDao;
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
        if (oldBook == null) {
            book.setBorrowed(0);
            book.setBorrowedTo("");
            bookDao.insert(book);
            return;
        }
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
    
    public int getMaxId() {
        return myDao.getMaxId();
    }
    
    public void deleteById(long id) {
        bookDao.deleteByPrimaryKey(id);
    }
}
