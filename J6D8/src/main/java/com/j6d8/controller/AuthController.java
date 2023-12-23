package com.j6d8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.j6d8.service.impl.UserServiceImpl;

@RequestMapping("/oauth2/login/success")
@Controller
public class AuthController {

    @Autowired
    UserServiceImpl impl;

    @GetMapping
    public String success(OAuth2AuthenticationToken oauth2) {
        impl.loginFormOAuth2(oauth2);
        return "forward:/security/login/success";
    }

}
