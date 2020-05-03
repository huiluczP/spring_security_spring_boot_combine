package com.ssbc.security;

import com.ssbc.service.UserInfoGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserInfoGetService userInfoGetService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/css/**", "/welcome").permitAll()
                    .antMatchers("/common/**").hasRole("COMMON_USER")
                    .antMatchers("/vip/**").hasRole("VIP_USER")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    //.antMatchers("/admin/**").permitAll()
                .and()
                .formLogin().loginPage("/login").failureUrl("/login_error").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //测试用，直接在内存中写入user1用户
        /*
        auth
                .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user1")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN");
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        */
        //设定service作为用户信息获取的来源
        auth
                .userDetailsService(userInfoGetService);

    }
}
