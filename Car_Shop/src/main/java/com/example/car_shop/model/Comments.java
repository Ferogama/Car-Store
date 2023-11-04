package com.example.car_shop.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}

