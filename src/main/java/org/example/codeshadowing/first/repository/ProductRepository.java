package org.example.codeshadowing.first.repository;

import org.example.codeshadowing.first.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

