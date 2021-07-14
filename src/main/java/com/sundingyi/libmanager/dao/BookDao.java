package com.sundingyi.libmanager.dao;

import com.sundingyi.libmanager.model.Book;
import com.sundingyi.libmanager.model.BookExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BookDao {
    long countByExample(BookExample example);
    
    int deleteByExample(BookExample example);
    
    int deleteByPrimaryKey(Long id);
    
    int insert(Book record);
    
    int insertSelective(Book record);
    
    List<Book> selectByExample(BookExample example);
    
    Book selectByPrimaryKey(Long id);
    
    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);
    
    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);
    
    int updateByPrimaryKeySelective(Book record);
    
    int updateByPrimaryKey(Book record);
}