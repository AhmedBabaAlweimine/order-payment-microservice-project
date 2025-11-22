package com.alweimine.orderservice.controller;

import com.alweimine.orderservice.dto.OrderDto;
import com.alweimine.orderservice.dto.TransactionRequest;
import com.alweimine.orderservice.dto.TransactionResponse;
import com.alweimine.orderservice.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/addOrder")
    public ResponseEntity<TransactionResponse> saveOrder(@RequestBody TransactionRequest transactionRequest) throws JsonProcessingException {
        return ResponseEntity.ok().body(orderService.addOrder(transactionRequest));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getAllOrder() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) throws JsonProcessingException {
        return ResponseEntity.ok().body(orderService.getOrder(id));
    }
}
