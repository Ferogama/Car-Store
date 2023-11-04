package com.example.car_shop.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SignInController {
    @GetMapping("/signIn")
    public String getSignInPage() {
        return "signInPage";
    }
}
