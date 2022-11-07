package com.jpmc.theater;

import java.time.LocalDateTime;

public record Showing(Movie movie, int sequenceOfTheDay, LocalDateTime startTime){}
