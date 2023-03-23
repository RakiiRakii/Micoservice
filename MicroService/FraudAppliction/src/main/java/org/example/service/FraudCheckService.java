package org.example.service;

import org.example.model.Fraud;
import org.example.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository)
    {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }
    public boolean isFraudulentCustomer(Integer customerID)
    {
        Fraud fraud=new Fraud();
        fraud.setCustomerID(customerID);
        fraud.setCreatedAt(LocalDateTime.now());
        fraud.setFraudster(false);
        fraudCheckHistoryRepository.save(fraud);
        return false;
    }
}
