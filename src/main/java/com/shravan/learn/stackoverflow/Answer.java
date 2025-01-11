package com.shravan.learn.stackoverflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Answer implements Commentable, Votable {
    private final int id;
    private final String content;
    private final User author;
    private final Question question;
    private boolean accepted;
    private final Date createdAt;
    private final List<Comment> comments;
    private final List<Vote> votes;

    public Answer(User author, Question question, String content) {
        this.id = IdGenerator.generate();
        this.content = content;
        this.author = author;
        this.question = question;
        this.createdAt = new Date();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.accepted = false;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void vote(User user, int value) {
        if (value != 1 && value != -1) {
            throw new IllegalArgumentException("Value can be 1 or -1");
        }
        votes.removeIf(v -> v.getUser().equals(user)); // remove existing vote by user
        votes.add(new Vote(user, value));
        author.updateReputation(value * 10); // +10 for upvote, -10 for downvote
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    public void markAsAccepted() {
        if (accepted) {
            throw new IllegalStateException("Aready accepted");
        }
        accepted = true;
        author.updateReputation(15); // +15 for accepted answer
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
