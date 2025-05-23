package com.catering.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Console {
    private static final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String message) {
        System.out.println(formatMessage("LOG", message));
    }

    public static void logError(String message) {
        System.err.println(formatMessage("ERROR", message));
    }

    public static void logWarning(String message) {
        System.out.println(formatMessage("WARNING", message));
    }

    public static void logInfo(String message) {
        System.out.println(formatMessage("INFO", message));
    }

    private static String formatMessage(String level, String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        return String.format("[%s] [%s] %s", timestamp, level, message);
    }
}
