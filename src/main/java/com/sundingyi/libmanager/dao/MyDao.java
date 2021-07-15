package com.sundingyi.libmanager.dao;

import org.apache.ibatis.annotations.Select;

public interface MyDao {
    @Select("SELECT MAX(id) FROM book")
    int getMaxId();
}
