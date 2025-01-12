package com.shravan.learn.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacebookService {

    Map<String, User> users;
    Map<String, Post> posts;

    public FacebookService() {
        users = new HashMap<>();
        posts = new HashMap<>();
    }

    public List<Post> getNewsFeed(User user) {
        List<Post> newsFeed = new ArrayList<>();
        for (User friend : user.getFriends()) {
            newsFeed.addAll(friend.getPosts());
        }
        newsFeed.sort((p1, p2) -> p2.getPostedAt().compareTo(p1.getPostedAt()));
        return newsFeed;
    }
}
