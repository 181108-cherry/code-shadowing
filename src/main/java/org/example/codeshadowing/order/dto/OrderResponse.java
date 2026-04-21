package org.example.codeshadowing.order.dto;

import lombok.Getter;
import org.example.codeshadowing.order.entity.Order;

@Getter
public class OrderResponse {

    private final Long orderId;
    private final Long productId;

    public OrderResponse(Order order) {
        this.orderId = order.getId();
        this.productId = order.getProduct().getId();
    }
}