package com.jpmc.theater;

public record Fee() {
    public static double applyFee(final double amount, final int seatQuantity) {
        return amount * seatQuantity;
    }
}
