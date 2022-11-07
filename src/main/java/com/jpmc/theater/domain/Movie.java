package com.jpmc.theater.domain;

import java.time.Duration;
import java.util.Objects;

public record Movie(String title, Duration runningTime, double price, boolean isSpecial) {
    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final Movie movie = (Movie) o;
        return Double.compare(movie.price, price) == 0 && isSpecial == movie.isSpecial && title.equals(movie.title) && runningTime.equals(movie.runningTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, runningTime, price, isSpecial);
    }
}