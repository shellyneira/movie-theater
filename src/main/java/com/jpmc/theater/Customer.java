package com.jpmc.theater;

import java.util.Objects;
import java.util.UUID;

public record Customer(String identifier, String name) {
    public Customer(final String name) {
        this(UUID.randomUUID().toString(), name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final Customer customer = (Customer) o;
        return Objects.equals(identifier, customer.identifier) && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, identifier);
    }

    @Override
    public String toString() {
        return "Customer{" + "identifier='" + identifier + '\'' + ", name='" + name + '\'' + '}';
    }
}