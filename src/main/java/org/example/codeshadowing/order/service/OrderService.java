package org.example.codeshadowing.order.service;

import lombok.RequiredArgsConstructor;
import org.example.codeshadowing.order.dto.OrderRequest;
import org.example.codeshadowing.order.dto.OrderResponse;
import org.example.codeshadowing.order.entity.Order;
import org.example.codeshadowing.order.repository.OrderRepository;
import org.example.codeshadowing.product.entity.Product;
import org.example.codeshadowing.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrderResponse createOrder(OrderRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "해당 상품이 존재하지 않습니다. id = " + request.getProductId()));

        Order order = new Order(product);
        Order saved = orderRepository.save(order);

        return new OrderResponse(saved);
    }

    public OrderResponse getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "해당 주문이 존재하지 않습니다. id = " + id));

        return new OrderResponse(order);
    }
}
