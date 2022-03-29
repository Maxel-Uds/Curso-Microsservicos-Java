package com.maxeluds.hrpayroll.services;

import com.maxeluds.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer days) {
        return new Payment("João", 42.78, days);
    }
}
