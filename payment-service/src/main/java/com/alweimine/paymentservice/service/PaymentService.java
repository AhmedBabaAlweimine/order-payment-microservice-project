package com.alweimine.paymentservice.service;

import com.alweimine.paymentservice.dto.PaymentDto;
import com.alweimine.paymentservice.entity.Payment;
import com.alweimine.paymentservice.repository.PaymentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private ModelMapper modelMapper;

    public PaymentDto doPayment(PaymentDto paymentDto) {
        paymentDto.setTransactionId(UUID.randomUUID().toString());
        paymentDto.setStatus(payementProcessing());
        Payment newPayment = modelMapper.map(paymentDto, Payment.class);
        Payment savedPayment = paymentRepo.save(newPayment);
        return modelMapper.map(savedPayment, PaymentDto.class);
    }


    public String payementProcessing() {
        return new Random().nextBoolean() ? "success" : "failed";
    }
}
