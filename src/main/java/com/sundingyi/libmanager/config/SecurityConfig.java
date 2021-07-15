package com.sundingyi.libmanager.config;


import com.sundingyi.libmanager.service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    private final MyUserDetailsService myUserDetailsService;
    
    public SecurityConfig(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
        
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin().loginPage("/login.html")
//                .loginProcessingUrl("/user/login")
//                .defaultSuccessUrl("/success").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/login.html", "/", "/user/login").permitAll()
//                .antMatchers("/haha").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and().csrf().disable();
    
    
        http.formLogin().defaultSuccessUrl("/").permitAll();
        http.authorizeRequests().antMatchers("/unauth").permitAll();
//        http.httpBasic();
//        http.authorizeRequests().antMatchers("/haha").hasAuthority("ADMIN");
        http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
        http.exceptionHandling().accessDeniedPage("/unauth");
    
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
    }
}
