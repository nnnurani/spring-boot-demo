package com.nurani.springbootdemo.customer;




import com.nurani.springbootdemo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id){
        return customerService.getCustomer(id);
    }

    @GetMapping("{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id){
       throw new ApiRequestException(
               "ApiRequestException for customer "+id
       );

    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("POST");
        System.out.println(customer);
    }
    @PutMapping
    void updateCustomer( @RequestBody Customer customer) {
        System.out.println("PUT");
        System.out.println(customer);
    }
    @DeleteMapping("{customerId}")
    void deleteCustomer (@PathVariable("customerId") Long id){
        System.out.println("DELETE"+ id);
    }
}
