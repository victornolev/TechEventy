package com.techevents.utils.loggers;

import com.techevents.utils.loggers.base.LoggerProvider;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Log4JLoggerProvider<T> implements LoggerProvider<T> {
    private Logger logger;

    public void setClass(Class<T> klass) {
        logger = Logger.getLogger(klass);
    }

    @Override
    public void info(Object message) {
        logger.info(message);
    }

    @Override
    public void error(Object message) {
        logger.error(message);
    }
}
