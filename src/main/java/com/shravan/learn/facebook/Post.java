package com.shravan.learn.facebook;

public class Post {
    String content;
    User postedBy;
    Long postedAt;
    public String getContent() {
        return content;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public Long getPostedAt() {
        return postedAt;
    }
}
