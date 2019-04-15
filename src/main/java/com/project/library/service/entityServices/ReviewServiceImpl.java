/*
Creates methods for review queries
 */

package com.project.library.service.entityServices;

import com.project.library.DAOs.ReviewRepository;
import com.project.library.entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    // autowire ReviewRepo
    private ReviewRepository reviewRepository;
    @Autowired
    public ReviewServiceImpl(ReviewRepository theReviewRepository){reviewRepository = theReviewRepository;}

    // search for complete list of reviews
    // this was more of a test method to make sure the entity and database were working
    // this method will most likely need deleted in the future
    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    // Method to save a review to database
    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findByReviewId_User_Username(String username) {
        return reviewRepository.findByReviewId_User_Username(username);
    }

    @Override
    public List<Review> findByReviewId_User_User_id(int user_id) {
        return reviewRepository.findByReviewId_User_UserId(user_id);
    }

}
