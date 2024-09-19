package com.rms.rmsapplication.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
    @PostMapping("/login")
    public void login()
    {
        return ;
    }

    @PostMapping("/logout")
    public void logout()
    {
        return;
    }
}
