package com.jpmc.theater.common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StringUtils {
    public static String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes( hour );

        return String.format( "%s hour%s %s minute%s", hour, handlePlural( hour ), remainingMin, handlePlural( remainingMin ) );
    }

    private static String handlePlural(final long value) {
        return value == 1 ? "" : "s";
    }
}