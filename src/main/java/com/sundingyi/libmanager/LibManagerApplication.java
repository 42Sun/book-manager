package com.sundingyi.libmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.sundingyi.libmanager.dao")
@SpringBootApplication
public class LibManagerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(LibManagerApplication.class, args);
    }
    
}
