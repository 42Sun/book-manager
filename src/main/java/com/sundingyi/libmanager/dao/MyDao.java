package com.sundingyi.libmanager.dao;

import com.sundingyi.libmanager.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MyDao {
    @Select("SELECT MAX(id) FROM book")
    int getMaxId();
    
    @Insert("insert into user (`username`, `password`, roles) values (#{username}, #{password}, #{roles})")
    void insert(User user);
}
