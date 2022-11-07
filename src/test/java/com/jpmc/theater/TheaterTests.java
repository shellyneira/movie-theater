package com.jpmc.theater;

import com.jpmc.theater.domain.Customer;
import com.jpmc.theater.domain.LocalDateProvider;
import com.jpmc.theater.domain.Ticket;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheaterTests {
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater( LocalDateProvider.singleton());
        Customer john = new Customer( "John Doe", "id-12345");
        Ticket ticket = theater.reserve( john, 2, 4 );
        ticket.applyFee();
        assertEquals(ticket.getTotalPrice(), 50 );
    }

    @Test
    void printMovieSchedule() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }
}
