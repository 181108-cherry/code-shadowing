package org.example.codeshadowing.first.dto;

import lombok.Getter;
import org.example.codeshadowing.first.entity.Product;

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
