package com.alweimine.paymentservice.controller;

import com.alweimine.paymentservice.dto.PaymentDto;
import com.alweimine.paymentservice.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("doPayment")
    public ResponseEntity<PaymentDto> processPayment(@RequestBody PaymentDto paymentDto) throws JsonProcessingException {
        return ResponseEntity.ok().body(paymentService.doPayment(paymentDto));
    }


    @GetMapping("/{orderId}")
    public ResponseEntity<PaymentDto> getPaymentByOrderId(@PathVariable Long orderId) throws JsonProcessingException {
        return ResponseEntity.ok().body(paymentService.getPaymentByOrderId(orderId));
    }
}
