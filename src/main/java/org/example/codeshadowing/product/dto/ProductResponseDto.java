package org.example.codeshadowing.product.dto;

import lombok.Getter;
import org.example.codeshadowing.product.entity.Product;

@Getter
public class ProductResponseDto {

    private final Long id;
    private final String name;
    private final Integer price;

    public ProductResponseDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
