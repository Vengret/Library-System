package com.project.library.DAOs;

import com.project.library.entities.Review;
import com.project.library.entities.ReviewId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, ReviewId> {
    List<Review> findByReviewId_User_Username(String username);
    List<Review> findByReviewId_User_UserId(int user_id);
}
