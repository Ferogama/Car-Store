package com.example.car_shop.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String name;
    private String color;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_car",
            joinColumns = {@JoinColumn(name = "car_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private List<User> users;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Comments> comments;

    @Lob
    private byte[] image;

    public void uploadImage(MultipartFile file) throws IOException {
        image = file.getBytes();
    }
}