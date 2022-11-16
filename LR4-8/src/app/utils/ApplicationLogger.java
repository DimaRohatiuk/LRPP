package app.utils;

import org.apache.log4j.Logger;

public class ApplicationLogger {

    public static void logInfo(Class<?> clazz, String message) {
        Logger.getLogger(clazz).info(message);
    }

    public static void logFatal(String message) {
        Logger.getLogger(ApplicationLogger.class).fatal(message);
    }

}
