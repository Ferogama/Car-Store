package com.example.car_shop.controllers;


import com.example.car_shop.dto.CarsForm;
import com.example.car_shop.sequrity.details.UserDetailsImpl;
import com.example.car_shop.services.CarsService;
import com.example.summerworkwebsite.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;



@Controller
public class CarsController {
    @Autowired
    private CarsService carsService;
    @Autowired
    private CommentsService commentsService;
    @GetMapping("/cars")
    public String getCarsPage(Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = userDetails.getRole();
        model.addAttribute("role", role);
        model.addAttribute("carsList", carsService.getAllCars());
        return "carsPage";
    }

    @GetMapping("/cars/{id}")
    public String getCarDetailPage(@PathVariable("id") Long id, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = userDetails.getRole();
        model.addAttribute("role", role);
        model.addAttribute("cars", carsService.getCarById(id));
        model.addAttribute("comments", commentsService.getCommentsByCarId(id));
        return "carsDetailPage";
    }

    @GetMapping("/cars/delete/{id}")
    public String deleteCar(@PathVariable("id") Long id) {
        carsService.deleteCar(id);
        return "redirect:/cars";
    }
    @GetMapping("/addCar")
    public String getCarsPage() {
        return "carsAddPage";
    }

    @PostMapping("/addCar")
    public String addNewCar(CarsForm form, @RequestParam("file") MultipartFile file) throws IOException {
        carsService.addNewCar(form, file);
        return "redirect:/cars";
    }
    @GetMapping("/cars/update/{id}")
    public String updateCar(@PathVariable Long id, Model model) {
        model.addAttribute("car", carsService.getCarById(id));
        return "carsUpdatePage";
    }
    @PostMapping("/updateCar")
    public String updateCar(CarsForm form, @RequestParam("file") MultipartFile file) throws IOException {
        carsService.updateCar(form, file);
        return "redirect:/cars";
    }
}
