package com.sundingyi.libmanager.service;

import com.sundingyi.libmanager.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    
    private final UserService userService;
    
    public MyUserDetailService(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        //从数据库查询用户信息
        User user = userService.getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        //查询权限信息
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = createAuthorities(user.getRoles());
        //返回Spring Security框架提供的User或者自定义的MyUser（implements UserDetails）
        ////        return new MyUser(username, userInfo.getPassword(), simpleGrantedAuthorities);
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), simpleGrantedAuthorities);
        
    }
    
    /**
     * 权限字符串转化
     * <p>
     * 如 "USER,ADMIN" -> SimpleGrantedAuthority("USER") + SimpleGrantedAuthority("ADMIN")
     *
     * @param roleStr 权限字符串
     */
    private List<SimpleGrantedAuthority> createAuthorities(String roleStr) {
        String[] roles = roleStr.split(",");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (String role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return simpleGrantedAuthorities;
    }
}