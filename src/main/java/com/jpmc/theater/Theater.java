package com.jpmc.theater;

import com.jpmc.theater.common.StringUtils;
import com.jpmc.theater.domain.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Theater {

    LocalDateProvider provider;
    private static List<Showing> schedule;

    public Theater(LocalDateProvider provider) {
        this.provider = provider;

        Movie spiderMan = new Movie( "Spider-Man: No Way Home", Duration.ofMinutes( 90 ), 12.5, true);
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, false);
        Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), 9, false);
        schedule = List.of(
            new Showing(turningRed, 1, LocalDateTime.of(provider.currentDate(), LocalTime.of(9, 0))),
            new Showing(spiderMan, 2, LocalDateTime.of(provider.currentDate(), LocalTime.of(11, 0))),
            new Showing(theBatMan, 3, LocalDateTime.of(provider.currentDate(), LocalTime.of(12, 50))),
            new Showing(turningRed, 4, LocalDateTime.of(provider.currentDate(), LocalTime.of(14, 30))),
            new Showing(spiderMan, 5, LocalDateTime.of(provider.currentDate(), LocalTime.of(16, 10))),
            new Showing(theBatMan, 6, LocalDateTime.of(provider.currentDate(), LocalTime.of(17, 50))),
            new Showing(turningRed, 7, LocalDateTime.of(provider.currentDate(), LocalTime.of(19, 30))),
            new Showing(spiderMan, 8, LocalDateTime.of(provider.currentDate(), LocalTime.of(21, 10))),
            new Showing(theBatMan, 9, LocalDateTime.of(provider.currentDate(), LocalTime.of(23, 0)))
        );
    }

    public Ticket reserve(Customer customer, int sequence, int howManyTickets) {
        Showing showing;
        try {
            showing = schedule.get(sequence - 1);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw new IllegalStateException("not able to find any showing for given sequence " + sequence);
        }
        return new Ticket(customer, showing, howManyTickets);
    }

    public void printSchedule() {
        System.out.println(provider.currentDate());
        System.out.println("===================================================");
        schedule.forEach(s ->
                System.out.println( s.sequenceOfTheDay() + ": " + s.startTime() + " " + s.movie().title() + " " + StringUtils.humanReadableFormat( s.movie().runningTime() ) + " $" + s.movie().price() )
        );
        System.out.println("===================================================");
    }

    public static void printScheduleAsJson(){
        schedule.forEach(s -> {
            System.out.println(StringUtils.stringToJson(s));
        });
    }

    public static void main(String[] args) {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
        theater.printScheduleAsJson();
    }
}
