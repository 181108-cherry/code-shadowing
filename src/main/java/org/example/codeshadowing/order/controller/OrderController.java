package org.example.codeshadowing.order.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.codeshadowing.order.dto.OrderRequest;
import org.example.codeshadowing.order.dto.OrderResponse;
import org.example.codeshadowing.order.entity.Order;
import org.example.codeshadowing.order.repository.OrderRepository;
import org.example.codeshadowing.product.entity.Product;
import org.example.codeshadowing.product.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @PostMapping("/id")
    @Transactional(readOnly = true)
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest request){
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "해당 상품이 존재하지 않습니다. id = " + request.getProductId()));

        Order order = new Order(product);
        Order saved = orderRepository.save(order);
        OrderResponse response = new OrderResponse(saved);
        return ResponseEntity.created(URI.create("/api/orders/" + response.getOrderId())).body(response);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "해당 주문이 존재하지 않습니다. id=" + id));
        return ResponseEntity.ok(new OrderResponse(order));
    }
}
