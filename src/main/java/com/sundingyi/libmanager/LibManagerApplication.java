package com.sundingyi.libmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@MapperScan("com.sundingyi.libmanager.dao")
@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class LibManagerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(LibManagerApplication.class, args);
    }
    
}
