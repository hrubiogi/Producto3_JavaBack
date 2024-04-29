package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
           .authorizeHttpRequests(authorize -> authorize
                .antMatchers("/admin/admin_pages").hasRole("ADMIN")
                .antMatchers("/user/user_pages").authenticated()
            )  
           .formLogin(form -> form
               .loginPage("/login")
               .permitAll()
            )
           .logout(logout -> logout
               .logoutSuccessUrl("/")
               .permitAll()
            );
    }
    
}