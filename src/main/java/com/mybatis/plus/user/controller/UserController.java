package com.mybatis.plus.user.controller;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-26
 */
@RestController
public class UserController {

    @GetMapping("/admin/hellow")
    public String adminHellow(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        return "admin hellow";
    }

    @GetMapping("/user/hellow")
    public String userHellow(){
        return "user hellow";
    }

    @GetMapping("/hellow")
    public String hellow(){
        return " hellow";
    }
}
