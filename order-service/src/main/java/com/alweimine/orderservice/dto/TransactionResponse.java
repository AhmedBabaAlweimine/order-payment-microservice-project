package com.alweimine.orderservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class TransactionResponse {
    private OrderDto orderDto;
    private PaymentDto paymentDto;
    private String message;

}
