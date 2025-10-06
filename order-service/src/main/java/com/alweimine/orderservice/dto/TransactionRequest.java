package com.alweimine.orderservice.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TransactionRequest {
    private OrderDto orderDto;
    private PaymentDto paymentDto;
}
