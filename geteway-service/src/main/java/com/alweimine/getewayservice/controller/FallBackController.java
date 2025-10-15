package com.alweimine.getewayservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping("/orderFallback")
    public Mono<String> orderServiceFallback() {
        return Mono.just("Order service is taiking too long to response,Please try later");
    }

    @RequestMapping("/paymentFallback")
    public Mono<String> paymentServiceFallback() {
        return Mono.just("payment service is taiking too long to response,Please try later");
    }
}
