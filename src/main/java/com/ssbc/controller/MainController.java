package com.ssbc.controller;

import com.ssbc.util.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private void setCurrentName(Model model){
        String currentName = SecurityUtil.getCurrentUserName();
        //System.err.println(currentName);
        if(!currentName.equals("null")){
            model.addAttribute("current_user",currentName);
        }
    }

    @RequestMapping("/")
    public String root(){
        return "redirect:/welcome";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/common/info")
    public String commonUserInfo(Model model){
        setCurrentName(model);
        return "common/info";
    }

    @RequestMapping("/vip/info")
    public String vipUserInfo(Model model){
        setCurrentName(model);
        return "vip/info";
    }

    @RequestMapping("/admin/info")
    public String adminInfo(Model model){
        setCurrentName(model);
        return "admin/info";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/login_error")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login";
    }
}
