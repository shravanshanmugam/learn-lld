package com.shravan.learn.rating;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Rating {
    private final RatingNumber ratingNumber;
    private final String title;
    private final String review;
    private final User user;
    private LocalDateTime ratedAt;


    public Rating(RatingNumber ratingNumber, String title, String review, User user) {
        this.ratingNumber = ratingNumber;
        this.title = title;
        this.review = review;
        this.user = user;
        ratedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "{" +
                "ratingNumber=" + ratingNumber +
                ", title='" + title + '\'' +
                ", review='" + review + '\'' +
                ", user=" + user +
                ", ratedAt=" + ratedAt +
                '}';
    }
}
