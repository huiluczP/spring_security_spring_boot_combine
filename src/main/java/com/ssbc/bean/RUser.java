package com.ssbc.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
    该类实现userdetails.User类，方便spring security进行用户记录
 */
public class RUser implements UserDetails, Serializable {

    private static final long serialVersionUID = 935664911799490702L;
    User user;

    public RUser(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = user.getRoles();
        if(!roles.isEmpty()){
            List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
            for(Role r: roles)
                list.add(new SimpleGrantedAuthority(r.getRole_name()));
            return list;
        }
        return null;
    }

    @Override
    public String getPassword() {

        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String passwordAfterEncoder = encoder.encode(user.getPassword());
        return "{bcrypt}" + passwordAfterEncoder;

        // return "{bcrypt}" + user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail(){
        return user.getEmail();
    }
}
