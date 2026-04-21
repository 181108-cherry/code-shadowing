package org.example.codeshadowing.product.repository;

import org.example.codeshadowing.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

