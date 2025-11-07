package com.alweimine.orderservice.service;


import com.alweimine.orderservice.dto.OrderDto;
import com.alweimine.orderservice.dto.PaymentDto;
import com.alweimine.orderservice.dto.TransactionRequest;
import com.alweimine.orderservice.dto.TransactionResponse;
import com.alweimine.orderservice.entity.Order;
import com.alweimine.orderservice.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RefreshScope
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @Value("${microservices.payment-service.endpoints.endpoint.uri}")
    private String paymentServiceUri;

    public TransactionResponse addOrder(TransactionRequest transactionRequest) {
        Order orderEntity = modelMapper.map(transactionRequest.getOrderDto(), Order.class);
        orderEntity = orderRepository.save(orderEntity);

        PaymentDto paymentDto = transactionRequest.getPaymentDto();
        paymentDto.setOrderId(orderEntity.getId());
        paymentDto.setAmount(orderEntity.getPrice());
        //call Payement service to save payement
        ResponseEntity<PaymentDto> PaymentDtoResponseEntity
                = restTemplate.postForEntity(paymentServiceUri, paymentDto, PaymentDto.class);                            //restTemplate.postForEntity(paymentServiceUri, paymentDto, PaymentDto.class);
        paymentDto = PaymentDtoResponseEntity.getBody();
        String message = paymentDto.getStatus().equalsIgnoreCase("success")
                ? "payement passed" : "payment failed";

        return new TransactionResponse(modelMapper.map(orderEntity, OrderDto.class), paymentDto, message);
    }

    public List<OrderDto> getAllOrders() {
        List<Order> allOrdes = orderRepository.findAll();
        return allOrdes.stream().map(order -> modelMapper.map(order, OrderDto.class)).collect(Collectors.toList());
    }

    public OrderDto geOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(value -> modelMapper.map(value, OrderDto.class)).orElse(null);
    }
}
