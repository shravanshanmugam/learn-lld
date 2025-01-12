package com.shravan.learn.facebook;

import java.util.Set;

public class User {
    Set<User> friends;
    Set<Post> posts;

    public Set<User> getFriends() {
        return friends;
    }

    public Set<Post> getPosts() {
        return posts;
    }
}
