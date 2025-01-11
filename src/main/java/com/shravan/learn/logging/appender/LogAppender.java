package com.shravan.learn.logging.appender;

import com.shravan.learn.logging.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
}
