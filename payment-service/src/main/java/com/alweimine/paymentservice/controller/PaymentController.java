package com.alweimine.paymentservice.controller;

import com.alweimine.paymentservice.dto.PaymentDto;
import com.alweimine.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payement")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("doPayment")
    public ResponseEntity<PaymentDto> processPayment(@RequestBody PaymentDto paymentDto) {
        return ResponseEntity.ok().body(paymentService.doPayment(paymentDto));
    }
}
