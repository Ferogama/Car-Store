package com.example.car_shop.controllers;


import com.example.car_shop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class UsersControllers {
    @Autowired
    private UsersService usersService;
    @GetMapping("/users")
    public String getUsersPage(Model model) {
        model.addAttribute("usersList",usersService.findAllUsers());
        return "usersPage";
    }
    @GetMapping("/users/del/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        usersService.deleteUser(id);
        return "redirect:/users";
    }
}
