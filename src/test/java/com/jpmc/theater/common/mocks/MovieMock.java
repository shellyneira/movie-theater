package com.jpmc.theater.common.mocks;

import com.jpmc.theater.domain.Movie;

import java.time.Duration;

public class MovieMock {

    public static Movie specialMovie() {
        return new Movie("The Woman King", Duration.ofMinutes(90), 12.5, true);
    }

    public static Movie nonSpecialMovie() {
        return new Movie("The Woman King", Duration.ofMinutes(90), 12.5, false);
    }

    public static Movie freeMovie() {
        return new Movie("The Woman King", Duration.ofMinutes(90), 0, true);
    }
}
