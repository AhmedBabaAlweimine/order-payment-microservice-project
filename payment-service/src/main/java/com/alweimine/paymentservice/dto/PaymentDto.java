package com.alweimine.paymentservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PaymentDto {
    private Long id;
    private String status;
    private String transactionId;
    private Long orderId;
    private double amount;
}
