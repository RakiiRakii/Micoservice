package org.example.controller;

import org.example.customerConfig.CustomerConfig;
import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CustomerController
{
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }
    @PostMapping("/add")
    public String createCustomer(@RequestBody Customer customer) {

        Customer customer1=new Customer();
        customer1.setName(customer.getName());
        customer1.setGmail(customer.getGmail());
        customer1.setPassword(customer.getPassword());
        repository.saveAndFlush(customer1);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8082/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class, customer1.getId()
        );
        if(fraudCheckResponse.IsFraidster())
        {
            try {
                throw  new IllegalAccessException("Fraudster") ;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return customer1.getName();
    }

}

