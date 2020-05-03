package com.ssbc.service;

import com.ssbc.bean.RUser;
import com.ssbc.bean.Role;
import com.ssbc.bean.User;
import com.ssbc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
    该类实现userDetailsService，返回Security包中的user对象
 */
@Service
public class UserInfoGetService implements UserDetailsService {

    private final UserDao userDao;

    public UserInfoGetService(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userDao.getUserByName(username);
        if(u == null){
            throw new UsernameNotFoundException("username not find");
        }
        // 将权限全部放入
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role r: u.getRoles()){
            authorities.add(new SimpleGrantedAuthority(r.getRole_name()));
        }
        //返回实现userDetails的user类
        return new RUser(u);
    }
}
