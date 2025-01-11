package com.shravan.learn.logging;

import java.util.Date;

public class LogMessage {
    private String message;
    private LogLevel level;
    private long timestamp;

    public LogMessage(LogLevel level, String message) {
        this.message = message;
        this.level = level;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return timestamp + " ["+level+"] " + message;
    }
}
