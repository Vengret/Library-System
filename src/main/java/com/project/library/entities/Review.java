/*
Tracks reviews left by users
 */


package com.project.library.entities;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    // Embedded Id allows the table to have a composite primary key
    // ReviewID consists of User user and Title title
    @EmbeddedId
    private ReviewId reviewId;

    // may be worth changing to an enum in the future
    // must be float and named preference for Mahout recommender
    @Column(name = "preference")
    private float value;

    @Column(name = "content")
    private String content;


    // Constructors

    public Review(){}

    public Review(ReviewId reviewId, float value, String content) {
        this.reviewId = reviewId;
        this.value = value;
        this.content = content;
    }

    // Getters and setters


    public ReviewId getReviewId() {
        return reviewId;
    }

    public void setReviewId(ReviewId reviewId) {
        this.reviewId = reviewId;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", value=" + value +
                ", content='" + content + '\'' +
                '}';
    }
}
