package com.jpmc.theater.common.mocks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateMock {
    public static LocalDate today() {
        return LocalDate.now();
    }

    public static LocalTime eleven() {
        return LocalTime.of(11, 0);
    }

    public static LocalTime sixteen() {
        return LocalTime.of(16, 0);
    }

    public static LocalDateTime todayEleven(){
        return LocalDateTime.of( today(), DateMock.eleven() );
    }

    public static LocalDateTime todaySixteen(){
        return LocalDateTime.of( today(), DateMock.sixteen() );
    }

    public static LocalDateTime todayNineteen(){
        return LocalDateTime.of(today(), LocalTime.of(19, 0));
    }

    public static LocalDateTime todayNoon(){
        return LocalDateTime.of(today(), LocalTime.of(12,0));
    }
}
