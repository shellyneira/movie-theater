package com.jpmc.theater.domain


import com.jpmc.theater.common.mocks.DateMock
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class DiscountUnitSpec extends Specification {

    def 'should apply 25% OFF when time is 11 am'() {
        given:
            Discount discount = new Discount()
        when:
            double result = discount.applyBestDiscount(12.5, DateMock.todayEleven(), false, 1)
        then:
            result == 9.375
    }

    def 'should apply 25% OFF when time is 16 pm'() {
        given:
            Discount discount = new Discount()
        when:
            double result = discount.applyBestDiscount(12.5, DateMock.todaySixteen(), false, 1)
        then:
            result == 9.375
    }

    def 'should apply 25% OFF when time is between 11 am and 16 pm'() {
        given:
            Discount discount = new Discount()
        when:
            double result = discount.applyBestDiscount(12.5, DateMock.todayNoon(), false, 1)
        then:
            result == 9.375
    }

    def 'should apply 20% OFF to special movie'() {
        given:
            Discount discount = new Discount()
        when:
            double result = discount.applyBestDiscount(12.5, DateMock.todayNineteen(), true, 4)
        then:
            result == 10
    }

    def 'should apply $3 OFF to 1st movie in the schedule sequence'() {
        given:
            Discount discount = new Discount()
        when:
            double result = discount.applyBestDiscount(12.5, DateMock.todayNineteen(), false, 1)
        then:
            result == 9.5
    }

    def 'should apply $2 OFF to 2nd movie in the schedule sequence'() {
        given:
        Discount discount = new Discount()
        when:
            double result = discount.applyBestDiscount(12.5, DateMock.todayNineteen(), false, 2)
        then:
            result == 10.5
    }

    def 'should apply $1 OFF to 7th movie in the schedule sequence'() {
        given:
            Discount discount = new Discount()
        when:
            double result = discount.applyBestDiscount(12.5, DateMock.todayNineteen(), false, 7)
        then:
            result == 11.5
    }

    def 'should apply the greatest discount given two or more discount possibilities'() {
        given:
            Discount discount = new Discount()
        when:
            double result = discount.applyBestDiscount(12.5, DateMock.todayNoon(), true, 1)
        then:
            result == 9.375
    }

    def 'should return zero if the discount make the price negative'() {
        given:
            Discount discount = new Discount()
        when:
            double result = discount.applyBestDiscount(1, DateMock.todayNoon(), true, 1)
        then:
            result >= 0
    }
}
