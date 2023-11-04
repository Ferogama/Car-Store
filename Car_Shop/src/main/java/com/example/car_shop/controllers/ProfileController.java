package com.example.car_shop.controllers;


import com.example.car_shop.model.User;
import com.example.car_shop.sequrity.details.UserDetailsImpl;
import com.example.car_shop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
    @Autowired
    private UsersService usersService;
    @GetMapping("/profile")
    public String getProfilePage(Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        Long id = userDetails.getId();
        String role = userDetails.getRole();

        model.addAttribute("email", email);
        model.addAttribute("id", id);
        model.addAttribute("role", role);
        return "profilePage";
    }
    @GetMapping("/profile/update/{id}")
    public String getProfileUpdatePage(@PathVariable Long id, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDetails.getId());
        return "profileUpdatePage";
    }
    @PostMapping("/update")
    public String updateUser(User user){
        usersService.save(user);
        return "redirect:/profile";
    }
}
