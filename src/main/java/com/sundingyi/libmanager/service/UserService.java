package com.sundingyi.libmanager.service;

import com.sundingyi.libmanager.dao.UserDao;
import com.sundingyi.libmanager.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;
    
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public User getUser(String username) {
        return userDao.selectByPrimaryKey(username);
    }
}
