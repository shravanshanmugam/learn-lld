package com.shravan.learn.logging.appender;

import com.shravan.learn.logging.LogMessage;

public class FileAppender implements LogAppender {
    @Override
    public void append(LogMessage logMessage) {
        System.out.println("write to file " + logMessage);
    }
}
