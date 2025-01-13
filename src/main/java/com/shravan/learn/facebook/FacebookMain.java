package com.shravan.learn.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Facebook -> map Users, map Posts, map user Notifications (userId -> Notifications)
// sendFriendRequest(sender userId, receiver userId)
// acceptFriendRequest(current userId, friend userId)
// getNewsFeed(current userId) -> get Friend Users and get their Posts, sort in decreasing order of timeStamp
// likePost(userId, postId)
// comment(Comment)

// NotificationType -> FRIEND_REQUEST, FRIEND_REQUEST_ACCEPTED, LIKE, COMMENT, MENTION
// User -> Friend Users, Posts
// Post -> content, created User, liked Users, Comments, timestamp
// Comment -> Post, created User, content
public class FacebookMain {


    public static void main(String[] args) {

    }
}
