package com.example.summerworkwebsite.services;

import com.example.car_shop.dto.CommentsForm;
import com.example.car_shop.model.Comments;

import java.util.List;

public interface CommentsService {
    List<Comments> getCommentsByCarId(Long carId);
    void addComment(Long carId, CommentsForm commentForm);
    void deleteComment(Long id);
}
