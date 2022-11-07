package com.jpmc.theater.common.mocks;

import com.jpmc.theater.domain.Customer;

public class CustomerMock {
    public static Customer shelly() {
        return new Customer("Shelly");
    }
}
