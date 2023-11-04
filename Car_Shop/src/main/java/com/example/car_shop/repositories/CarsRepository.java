package com.example.car_shop.repositories;

import com.example.car_shop.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Car,Long>{
}
