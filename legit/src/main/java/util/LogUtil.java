package util;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class LogUtil {

    public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }

    public static void logException(Logger logger, Exception e) {
        logger.error("Exception occurred: " + e.getMessage(), e);
    }
}