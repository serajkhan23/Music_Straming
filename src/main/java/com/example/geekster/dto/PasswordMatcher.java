package com.example.geekster.dto;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordMatcher {
    public static boolean passwordMatcher(String ExistingPassword,String InputPassword){
        return ExistingPassword.equals(InputPassword);
    }
}