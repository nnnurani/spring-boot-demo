package com.nurani.springbootdemo.customer;

import java.util.Arrays;
import java.util.List;

//@Component(value = "fake")
public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L,"Mike", "password123","mike@gmail.com"),
                new Customer(2L, "Eleven", "123password", "el11@hotmail.com")
        );
    }
}
