package org.example.contorller;

import org.example.model.Fraud;
import org.example.repository.FraudCheckHistoryRepository;
import org.example.service.FraudCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/fraud-check/")
public class FraudController {

    @Autowired
    FraudCheckService fraudCheckService;
    @Autowired
    FraudCheckHistoryRepository fraudCheckHistoryRepository;


    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID)
    {
       boolean isFrauduentCustomer =  fraudCheckService.isFraudulentCustomer(customerID);
       return new FraudCheckResponse(isFrauduentCustomer);
    }

    @PostMapping("/add")
    public String isFraudster(@RequestBody Fraud fraud)
    {
        fraudCheckHistoryRepository.save(fraud);
        return "Done";
    }








}
