package com.shravan.learn.logging;

import com.shravan.learn.logging.appender.LogAppender;

public class LoggerConfig {
    private LogLevel level;
    private LogAppender appender;

    public LoggerConfig(LogLevel level, LogAppender appender) {
        this.level = level;
        this.appender = appender;
    }

    public LogLevel getLevel() {
        return level;
    }

    public LogAppender getAppender() {
        return appender;
    }
}
