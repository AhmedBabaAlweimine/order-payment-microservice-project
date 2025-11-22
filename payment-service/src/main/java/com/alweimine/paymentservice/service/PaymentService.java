package com.alweimine.paymentservice.service;

import com.alweimine.paymentservice.dto.PaymentDto;
import com.alweimine.paymentservice.entity.Payment;
import com.alweimine.paymentservice.repository.PaymentRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(PaymentService.class);

    public PaymentDto doPayment(PaymentDto paymentDto) throws JsonProcessingException {
        logger.info("PaymentService: doPayment request: {}", new ObjectMapper().writeValueAsString(paymentDto));
        paymentDto.setTransactionId(UUID.randomUUID().toString());
        paymentDto.setStatus(payementProcessing());
        Payment newPayment = modelMapper.map(paymentDto, Payment.class);
        Payment savedPayment = paymentRepo.save(newPayment);
        return modelMapper.map(savedPayment, PaymentDto.class);
    }


    public String payementProcessing() {
        return new Random().nextBoolean() ? "success" : "failed";
    }

    public PaymentDto getPaymentByOrderId(Long orderId) throws JsonProcessingException {
        logger.info("PaymentService: getPaymentByOrderId request: {}", new ObjectMapper().writeValueAsString(orderId));
        return modelMapper.map(paymentRepo.findByOrderId(orderId), PaymentDto.class);
    }
}
