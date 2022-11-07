package com.jpmc.theater;

import java.time.LocalDateTime;

public record Discount() {
    private static final double COMMERCIAL_TIME_PERCENTAGE_OFF = 25;
    private static final double SPECIAL_MOVIE_PERCENTAGE_OFF = 20;
    private static final double FIRST_SEQUENCE_DOLLARS_OFF = 3;
    private static final double SECOND_SEQUENCE_DOLLARS_OFF = 2;
    private static final double SEVENTH_SEQUENCE_DOLLARS_OFF = 1;

    /**
     * Apply the best (1) discount eligible, then return the amount with discount applied.
     * @param amount ticket price
     * @param startTime which hour the ticket was bought
     * @param isSpecial if the movie to be watched is special or not
     * @param sequenceOfTheDay the ordinary number regard the sequence of showings today
     * @return amount after the applied discount
     */
    public static double applyBestDiscount(final double amount, final LocalDateTime startTime, final boolean isSpecial, final int sequenceOfTheDay) {
       final var percentageDiscount = Math.max( getCommercialTimeDiscount( startTime.getHour() ), getSpecialMovieDiscount( isSpecial ) );
       final var dollarsDiscount = getSequenceDiscount(sequenceOfTheDay);
       final var amountPercentageOff = applyPercentageOff( amount, percentageDiscount );
       final var amountDollarsOf = applyDollarsOff( amount, dollarsDiscount );
       return Math.min(amountPercentageOff, amountDollarsOf);
    }

    private static double getSpecialMovieDiscount(final boolean isSpecial){
        return isSpecial ? SPECIAL_MOVIE_PERCENTAGE_OFF : 0;
    }

    private static double getCommercialTimeDiscount(final int hour){
        return (hour >= 11 && hour <= 16) ? COMMERCIAL_TIME_PERCENTAGE_OFF : 0;
    }

    private static double getSequenceDiscount(final int sequenceOfTheDay){
        return switch (sequenceOfTheDay) {
            case 1 -> FIRST_SEQUENCE_DOLLARS_OFF;
            case 2 -> SECOND_SEQUENCE_DOLLARS_OFF;
            case 7 -> SEVENTH_SEQUENCE_DOLLARS_OFF;
            default -> 0;
        };
    }

    private static double applyPercentageOff(final double amount, final double percentage){
        return amount - (amount * percentage / 100);
    }

    private static double applyDollarsOff(final double amount, final double dollars){
        var total = amount - dollars;
        return total < 0 ? 0 : total;
    }
}
