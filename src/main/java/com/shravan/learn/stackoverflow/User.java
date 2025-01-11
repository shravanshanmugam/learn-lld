package com.shravan.learn.stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private final String name;
    private int reputation;

    private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;

    public static final int QUESTION_REPUTATION = 5;
    public static final int ANSWER_REPUTATION = 10;
    public static final int COMMENT_REPUTATION = 2;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public Question askQuestion(String title, String content, List<String> tags) {
        Question question = new Question(this, title, content, tags);
        questions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion(Question question, String content) {
        Answer answer = new Answer(this, question, content);
        answers.add(answer);
        question.addAnswer(answer);
        updateReputation(ANSWER_REPUTATION);
        return answer;
    }

    public Comment addComment(Commentable commentable, String content) {
        Comment comment = new Comment(this, content);
        comments.add(comment);
        commentable.addComment(comment);
        updateReputation(COMMENT_REPUTATION);
        return comment;
    }

    public synchronized void updateReputation(int value) {
        reputation += value;
        if (reputation < 0) {
            reputation = 0;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReputation() {
        return reputation;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
