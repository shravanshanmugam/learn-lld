package com.shravan.learn.linkedin;

// LinkedInService -> map Users, map JobPostings, map user Notifications (userId -> Notifications)
// registerUser(User)
// sendConnectionRequest(sender User, receiver User) -> add Connection to receiver User, addNotification to receiver User
// acceptConnectionRequest(User, connectionUser User) -> add Connection to User
// postJob() -> addNotification to all users
// sendMessage(sender User, receiver User, content) -> add to receiver User Inbox, add to sender Sent message, addNotification to recipient User,

// User -> name, Profile, Connections, Inbox Message, Sent Messages
// Connection -> connection User, timestamp
// Message -> send User, recipient User, content, timestamp
// Notification -> NotificationType, recipient User, content, timestamp
public class LinkedinMain {
    public static void main(String[] args) {

    }
}
