package com.theblackdre1d.semestralka.controllers;

import com.theblackdre1d.semestralka.models.Customer;
import com.theblackdre1d.semestralka.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository mCustomerRepo;

    @PostMapping("/saveCustomer")
    public int saveCustomer(@RequestBody List<Customer> customers) {
        mCustomerRepo.saveAll(customers);
        return customers.size();
    }

    @GetMapping("/findAll")
    public Iterable<Customer> findAllCustomers() {
        return mCustomerRepo.findAll();
    }

    @GetMapping("/findByFirstName/{firstName}")
    public List<Customer> findByFirstName(@PathVariable String firstName) {
        return mCustomerRepo.findByFirstName(firstName);
    }
}
