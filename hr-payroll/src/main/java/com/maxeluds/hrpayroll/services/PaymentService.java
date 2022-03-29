package com.maxeluds.hrpayroll.services;

import com.maxeluds.hrpayroll.entities.Payment;
import com.maxeluds.hrpayroll.entities.Worker;
import com.maxeluds.hrpayroll.feignClients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient client;

    public Payment getPayment(Long workerId, Integer days) {
        var worker = getWorker(workerId);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

    private Worker getWorker(Long id) {
        return client.findById(id).getBody();
    }
}
