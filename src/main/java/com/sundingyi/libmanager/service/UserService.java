package com.sundingyi.libmanager.service;

import com.sundingyi.libmanager.dao.UserDao;
import com.sundingyi.libmanager.model.User;
import com.sundingyi.libmanager.model.UserExample;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;
    
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public List<User> getUsers() {
        UserExample userExample = new UserExample();
        return userDao.selectByExample(userExample);
    }
    
    public User findByName(String s) {
        return userDao.selectByPrimaryKey(s);
    }
    
}
