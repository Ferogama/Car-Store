package com.example.car_shop.services;

import com.example.car_shop.dto.CarsDto;
import com.example.car_shop.dto.CarsForm;
import com.example.car_shop.model.Car;
import com.example.car_shop.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;



@Component
public class  CarsServiceImpl implements CarsService {
    @Autowired
    private CarsRepository carsRepository;

    @Override
    public List<CarsDto> getAllCars() {
        List<Car> cars = carsRepository.findAll();
        List<CarsDto> carsDtoList = new ArrayList<>();

        for (Car car : cars) {
            CarsDto carsDto = new CarsDto();
            carsDto.setId(car.getId());
            carsDto.setModel(car.getModel());
            carsDto.setName(car.getName());
            carsDto.setColor(car.getColor());
            carsDto.setImage(Base64.getEncoder().encodeToString(car.getImage()));
            carsDtoList.add(carsDto);
        }
        return carsDtoList;
    }

    @Override
    public void addNewCar(CarsForm form, MultipartFile file) throws IOException {
        Car newCar = Car.builder()
                .color(form.getColor())
                .model(form.getModel())
                .name(form.getName())
                .build();
        newCar.uploadImage(file);
        carsRepository.save(newCar);
    }

    @Override
    public Car getCarById(Long id) {
        Car car = carsRepository.findById(id).orElse(null);

        if (car != null && car.getImage() != null) {
            try {
                car.setImage(Base64.getEncoder().encode(car.getImage()));
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        return car;
    }


    @Override
    public void deleteCar(Long id) {
        carsRepository.deleteById(id);
    }

    @Override
    public void updateCar(CarsForm form, MultipartFile file) throws IOException {
        Long carId = form.getId();
        Car car = carsRepository.findById(carId).orElse(null);

        if (car != null) {
            car.setColor(form.getColor());
            car.setModel(form.getModel());
            car.setName(form.getName());

            if (!file.isEmpty()) {
                car.uploadImage(file);
            }

            carsRepository.save(car);
        }
    }
}