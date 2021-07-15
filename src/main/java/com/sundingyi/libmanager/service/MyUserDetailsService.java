package com.sundingyi.libmanager.service;


import com.sundingyi.libmanager.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserService userSerivice;
    
    public MyUserDetailsService(UserService userSerivice) {
        this.userSerivice = userSerivice;
    }
    
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userSerivice.findByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户找不到");
        } else {
            List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles());
            return new org.springframework.security.core.userdetails.User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), auths);
        }
    }
}
