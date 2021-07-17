package com.sundingyi.libmanager.dao;

import com.sundingyi.libmanager.model.User;
import com.sundingyi.libmanager.model.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    long countByExample(UserExample example);
    
    int deleteByExample(UserExample example);
    
    int deleteByPrimaryKey(String username);
    
    int insert(User record);
    
    int insertSelective(User record);
    
    List<User> selectByExample(UserExample example);
    
    User selectByPrimaryKey(String username);
    
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);
    
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    
    int updateByPrimaryKeySelective(User record);
    
    int updateByPrimaryKey(User record);
}