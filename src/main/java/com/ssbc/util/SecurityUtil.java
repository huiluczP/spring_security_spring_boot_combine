package com.ssbc.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtil {
    public static String getCurrentUserName(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal!=null) {
            System.out.println(principal.toString());
            return ((UserDetails) principal).getUsername();
        }
        return String.valueOf(principal);
    }
}
