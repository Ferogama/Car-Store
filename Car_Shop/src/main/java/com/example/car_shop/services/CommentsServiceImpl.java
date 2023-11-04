package com.example.car_shop.services;

import com.example.car_shop.dto.CommentsForm;
import com.example.car_shop.model.Car;
import com.example.car_shop.model.Comments;
import com.example.car_shop.repositories.CarsRepository;
import com.example.car_shop.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class CommentsServiceImpl implements com.example.summerworkwebsite.services.CommentsService {
    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    private CarsRepository carsRepository;

    @Override
    public List<Comments> getCommentsByCarId(Long carId) {
        return commentsRepository.findCommentsByCarId(carId);
    }

    @Override
    public void addComment(Long carId, CommentsForm commentForm) {
        Car car = carsRepository.findById(carId).orElseThrow(() -> new EntityNotFoundException("Car not found"));
        Comments comment = new Comments();
        comment.setCar(car);
        comment.setText(commentForm.getText());
        commentsRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        Optional<Comments> commentOptional = commentsRepository.findById(id);
        if (commentOptional.isPresent()) {
            commentsRepository.deleteById(id);
        } else {
            System.out.println("Cant delete comment");
        }
    }
}
