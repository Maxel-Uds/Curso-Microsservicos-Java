package com.maxeluds.hrpayroll.services;

import com.maxeluds.hrpayroll.entities.Payment;
import com.maxeluds.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerHost;

    public Payment getPayment(Long workerId, Integer days) {
        var worker = getWorker(workerId);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

    private Worker getWorker(Long id) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(id));

        return restTemplate.getForObject(workerHost.concat("/workers/{id}"), Worker.class, uriVariables);
    }
}
