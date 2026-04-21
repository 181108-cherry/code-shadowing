package org.example.codeshadowing.third.dto;

import lombok.Getter;
import org.example.codeshadowing.third.entity.ProductEntity;

@Getter
public class ResponseDto {

    private final Long id;
    private final String name;
    private final Integer price;

    public ResponseDto(ProductEntity product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
