package com.sundingyi.libmanager.dao;

import com.sundingyi.libmanager.model.Book;
import com.sundingyi.libmanager.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MyDao {
    @Select("SELECT MAX(id) FROM book")
    int getMaxId();
    
    @Insert("insert into user (`username`, `password`, roles) values (#{username}, #{password}, #{roles})")
    void insert(User user);
    
    @Select("select * from user where username like concat('%', #{username}, '%')")
    List<User> findLikeName(String username);
    
    @Select("select * from book where bookname like concat('%', #{bookname}, '%') and author like concat('%', #{author}, '%')")
    List<Book> findLikeBook(String bookname, String author);
    
    @Select("select * from book where borrowed = 0 and borrowed_to like concat('%', #{username}, '%')")
    List<Book> findBorrowLikeName(String username);
}
