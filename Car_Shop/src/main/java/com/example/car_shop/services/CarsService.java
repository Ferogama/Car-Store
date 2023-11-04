package com.example.car_shop.services;

import com.example.car_shop.dto.CarsDto;
import com.example.car_shop.dto.CarsForm;
import com.example.car_shop.model.Car;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;


public interface CarsService {
    List<CarsDto> getAllCars();
    void addNewCar(CarsForm form, MultipartFile file) throws IOException;
    Car getCarById(Long id);
    void deleteCar(Long id);
    void updateCar(CarsForm form, MultipartFile file) throws IOException;

}

