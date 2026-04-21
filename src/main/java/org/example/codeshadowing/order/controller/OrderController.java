package org.example.codeshadowing.order.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.codeshadowing.order.dto.OrderRequest;
import org.example.codeshadowing.order.dto.OrderResponse;
import org.example.codeshadowing.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest request) {
        OrderResponse response = orderService.createOrder(request);
        return ResponseEntity
                .created(URI.create("/api/orders/" + response.getOrderId()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        OrderResponse response = orderService.getOrder(id);
        return ResponseEntity.ok(response);
    }
}