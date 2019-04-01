package com.project.library.service.entityServices;

import com.project.library.entities.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();
    Review createReview(Review review);
    List<Review> findByReviewId_User_Username(String username);
    List<Review> findByReviewId_User_User_id(int user_id);
}
