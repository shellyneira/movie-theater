package com.jpmc.theater.domain


import com.jpmc.theater.common.mocks.DateMock
import com.jpmc.theater.common.mocks.MovieMock
import com.jpmc.theater.common.mocks.CustomerMock
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class TicketIntegratedSpec extends Specification {

    def 'should apply fee based on seats'() {
        given:
            Showing showing = new Showing(MovieMock.nonSpecialMovie(), 4, DateMock.todayNineteen())
            Ticket ticket = new Ticket(CustomerMock.shelly(), showing, 3)
        when:
            ticket.applyFee()
        then:
            ticket.getTotalPrice() == 37.5
    }

    def 'should apply discount to every seat'() {
        given:
            Showing showing = new Showing(MovieMock.specialMovie(), 4, DateMock.todayNineteen())
            Ticket ticket = new Ticket(CustomerMock.shelly(), showing, 3)
        when:
            ticket.applyDiscount()
            ticket.applyFee()
        then:
            ticket.getTotalPrice() == 30
    }
}
