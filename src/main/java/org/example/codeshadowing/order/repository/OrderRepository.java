package org.example.codeshadowing.order.repository;

import org.example.codeshadowing.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
