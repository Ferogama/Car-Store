package com.example.car_shop.controllers;

import com.example.car_shop.dto.CommentsForm;
import com.example.summerworkwebsite.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CommentsController {
    @Autowired
    private CommentsService commentsService;
    @PostMapping("/addComment/{carId}")
    public String addComment(@PathVariable("carId") Long carId, CommentsForm commentForm) {
        commentsService.addComment(carId, commentForm);
        return "redirect:/cars/" + carId;
    }
    @GetMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable("id") Long id) {
        commentsService.deleteComment(id);
        return "redirect:/cars";
    }
}
