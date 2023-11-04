package com.example.car_shop.controllers;

import com.example.car_shop.dto.UserForm;
import com.example.car_shop.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;



@Controller
public class SignUpController {
    @Autowired
    private SignUpService signUpService;
    @GetMapping("/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", new UserForm());
        return "signUpPage";
    }
    @PostMapping("/signUp")
    public String signUp(@Valid @ModelAttribute("user") UserForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", form);
            model.addAttribute("errors", bindingResult);
            return "signUpPage";
        }

        signUpService.signUp(form);
        return "redirect:/signIn";
    }
}
