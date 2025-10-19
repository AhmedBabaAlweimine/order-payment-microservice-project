package com.alweimine.getewayservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping("/orderFallback")
    public ResponseEntity<String> orderServiceFallback() {
        return ResponseEntity.ok().body("Order service is taiking too long to response,Please try later");
    }

    @RequestMapping("/paymentFallback")
    public ResponseEntity<String> paymentServiceFallback() {
        return ResponseEntity.ok().body("payment service is taiking too long to response,Please try later");
    }
}
