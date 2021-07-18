package com.sundingyi.libmanager.service;

import com.github.pagehelper.PageInfo;
import com.sundingyi.libmanager.dao.MyDao;
import com.sundingyi.libmanager.dao.UserDao;
import com.sundingyi.libmanager.model.Book;
import com.sundingyi.libmanager.model.User;
import com.sundingyi.libmanager.model.UserExample;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;
    private final MyDao myDao;
    
    public UserService(UserDao userDao, MyDao myDao) {
        this.userDao = userDao;
        this.myDao = myDao;
    }
    
    public List<User> getUsers() {
        UserExample userExample = new UserExample();
        return userDao.selectByExample(userExample);
    }
    
    public User findByName(String s) {
        return userDao.selectByPrimaryKey(s);
    }
    
    private void encryptPassword(User user) {
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);
    }
    
    public void insertOrUpdate(User user) {
        User dbUser = userDao.selectByPrimaryKey(user.getUsername());
        encryptPassword(user);
        if (dbUser == null) { //无这个用户。新增
            myDao.insert(user);
        } else { //有这个用户，修改
            userDao.updateByPrimaryKey(user);
        }
    }
    
    public void deleteByUsername(String username) {
        userDao.deleteByPrimaryKey(username);
    }
    
    
    public List<User> findLikeName(String username) {
        List<User> userList = myDao.findLikeName(username);
        return userList;
    }
    
    public List<Book> findLikeBook(String bookname, String author) {
        List<Book> bookList = myDao.findLikeBook(bookname, author);
        return bookList;
    }
    
    public PageInfo<Book> findBorrowByName(String username) {
        List<Book> bookList = myDao.findBorrowLikeName(username);
        return new PageInfo<>(bookList);
    }
}
