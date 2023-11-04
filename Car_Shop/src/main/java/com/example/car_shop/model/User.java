package com.example.car_shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//Название таблицы которая создастся
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Email cannot be empty")
    @Size(min = 7)
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "password can not be empty")
    @Size(min = 3)
    private String hashPassword;

    //большое количество машин у пользователя
    @ManyToMany(mappedBy = "users")
    private List<Car> cars;


    //хранение в виде строк)
    @Enumerated(value = EnumType.STRING)
    private Role role;
    public enum Role {
        USER, ADMIN
    }
}
