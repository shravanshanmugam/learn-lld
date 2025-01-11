package com.shravan.learn.logging;

import com.shravan.learn.logging.appender.ConsoleAppender;

public class Logger {
    private static Logger instance = new Logger();

    private LoggerConfig config;
    private Logger() {
        config = new LoggerConfig(LogLevel.INFO, new ConsoleAppender());
    }

    public static Logger getInstance() {
        return instance;
    }

    public void setConfig(LoggerConfig config) {
        this.config = config;
    }

    private void log(LogLevel level, String message) {
        if (level.ordinal() >= config.getLevel().ordinal()) {
            config.getAppender().append(new LogMessage(level, message));
        }
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}
