package com.sundingyi.libmanager.service;

import com.sundingyi.libmanager.dao.MyDao;
import com.sundingyi.libmanager.dao.UserDao;
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
    
    public void insert(User user) {
        encryptPassword(user);
        myDao.insert(user);
    }
}
