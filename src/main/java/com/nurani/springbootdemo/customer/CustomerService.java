package com.nurani.springbootdemo.customer;

import com.nurani.springbootdemo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;


    List<Customer> getCustomers(){
        log.info("getCustomer was called");
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("customer with id " + id + " not found");
                    log.error("error in getting customer {}", id, notFoundException);

                    return notFoundException;
                });
    }}
//public Customer getCustomer(Long id) {
//    return customerRepository.getCustomers()
//            .stream()
//            .filter(customer -> customer.getId().equals(id))
//            .findFirst()
//            .orElseThrow(() -> {
//                NotFoundException notFoundException = new NotFoundException("customer with id " + id + " not found");
//                LOGGER.error("error in getting customer {}", id, notFoundException);
//
//                return notFoundException;
//            });
//}
//}
