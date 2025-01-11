package com.shravan.learn.stackoverflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stackoverflow {
    private final Map<Integer, User> users;
    private final Map<Integer, Question> questions;
    private final Map<Integer, Answer> answers;
    private final Map<String, Tag> tags;

    public Stackoverflow() {
        this.users = new HashMap<>();
        this.questions = new HashMap<>();
        this.answers = new HashMap<>();
        this.tags = new HashMap<>();
    }

    public User createUser(String name) {
        int id = users.size() + 1;
        User user = new User(id, name);
        users.put(id, user);
        return user;
    }

    public Question askQuestion(User user, String title, String content, List<String> tags) {
        Question question = user.askQuestion(title, content, tags);
        questions.put(question.getId(), question);
        for (Tag tag : question.getTags()) {
            this.tags.putIfAbsent(tag.getName(), tag);
        }
        return question;
    }

    public Answer answerQuestion(User user, Question question, String content) {
        Answer answer = user.answerQuestion(question, content);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public Comment addComment(User user, Commentable commentable, String content) {
        return user.addComment(commentable, content);
    }

    public void voteQuestion(User user, Question question, int value) {
        question.vote(user, value);
    }

    public void voteAnswer(User user, Answer answer, int value) {
        answer.vote(user, value);
    }

    public void acceptAnswer(Answer answer) {
        answer.markAsAccepted();
    }

    public List<Question> search(String query) {
        String lq = query.toLowerCase();
        return questions.values().stream()
                .filter(q -> q.getTitle().toLowerCase().contains(lq) ||
                        q.getContent().toLowerCase().contains(lq) ||
                        q.getTags().stream().anyMatch(t -> t.getName().toLowerCase().equals(lq)))
                .collect(Collectors.toList());
    }

    public List<Question> getQuestionsByUser(User user) {
        return user.getQuestions();
    }
}
