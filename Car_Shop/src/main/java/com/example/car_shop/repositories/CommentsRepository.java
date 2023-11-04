package com.example.car_shop.repositories;

import com.example.car_shop.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments,Long> {
    @Query("SELECT c FROM Comments c WHERE c.car.id = :carId")
    List<Comments> findCommentsByCarId(Long carId);
}
