package com.alweimine.paymentservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PAYMENT_TB")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;
    private String transactionId;
    private Long orderId;
    private double amount;
}
