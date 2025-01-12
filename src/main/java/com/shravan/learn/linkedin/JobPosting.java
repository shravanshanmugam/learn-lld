package com.shravan.learn.linkedin;

import java.util.List;
import java.util.UUID;

public class JobPosting {
    private final String id;
    private final String title;
    private final String description;
    private final List<String> requirements;
    private final String location;
    private final long postDate;

    public JobPosting(String title, String description, List<String> requirements, String location) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.location = location;
        this.postDate = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public String getLocation() {
        return location;
    }

    public long getPostDate() {
        return postDate;
    }
}
