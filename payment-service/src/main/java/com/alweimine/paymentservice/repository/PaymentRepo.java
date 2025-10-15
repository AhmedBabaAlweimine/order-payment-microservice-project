package com.alweimine.paymentservice.repository;

import com.alweimine.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    Payment findByOrderId(Long orderId);
}
