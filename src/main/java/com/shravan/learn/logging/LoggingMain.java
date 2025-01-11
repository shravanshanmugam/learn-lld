package com.shravan.learn.logging;

import com.shravan.learn.logging.appender.DatabaseAppender;

// Logger -> LoggerConfig -> LogLevel, LogAppender
public class LoggingMain {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.debug("hello");
        logger.info("how");
        logger.warn("are");
        logger.error("you");
        logger.fatal("now");

        logger.setConfig(new LoggerConfig(LogLevel.ERROR, new DatabaseAppender()));

        logger.debug("hello");
        logger.info("how");
        logger.warn("are");
        logger.error("you");
        logger.fatal("now");

    }
}
