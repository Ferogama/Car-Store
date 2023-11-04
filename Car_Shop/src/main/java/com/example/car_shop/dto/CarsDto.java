package com.example.car_shop.dto;

import com.example.car_shop.model.Car;
import com.example.car_shop.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarsDto {
    private Long id;
    private String model;
    private String name;
    private String color;
    private String image;


    public static CarsDto from(Car car) {
        return CarsDto.builder()
                .id(car.getId())
                .model(car.getModel())
                .name(car.getName())
                .color(car.getColor())
                .build();
    }
    public static List<CarsDto> from (List<Car> car) {
        return car.stream()
                .map(CarsDto::from)
                .collect(Collectors.toList());
    }
}
