package com.jpmc.theater;

import lombok.Getter;

@Getter
public class Ticket {
    private Customer customer;
    private Showing showing;
    private int seats;
    private double totalPrice;

    public Ticket(final Customer customer, Showing showing, int seats) {
        this.customer = customer;
        this.showing = showing;
        this.seats = seats;
        this.totalPrice = showing.movie().price();
    }

    public void applyDiscount() {
        this.totalPrice = Discount.applyBestDiscount(totalPrice, showing.startTime(), showing.movie().isSpecial(), showing.sequenceOfTheDay());
    }

    public void applyFee() {
        this.totalPrice = Fee.applyFee(totalPrice, seats);
    }
}