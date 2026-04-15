package org.example.codeshadowing.service;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.codeshadowing.dto.ProductRequestDto;
import org.example.codeshadowing.dto.ProductResponseDto;
import org.example.codeshadowing.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductResponseDto createProduct(@Valid ProductRequestDto request){
        Product product = new Product(request.getName(), request.getPrice());
        Product saved = productRepository.save(product);
        return new ProductResponseDto(saved);
    }

    public ProductResponseDto getProduct(Long id){
        Product product = findProductById(id);
        return new ProductResponseDto(product);
    }

    public List<ProductResponseDto> getProducts(){
        return productRepository.findAll().stream()
                .map(ProductResponseDto::new).
                toList();
    }

    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductRequestDto request){
        Product product = findProductById(id);
        product.update(request.getName(), request.getPrice());
        return new ProductResponseDto(product);
    }

    @Transactional
    public void deleteProduct(Long id){
        Product product = findProductById(id);
        productRepository.delete(product);
    }

    private Product findProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다. id=" + id));
    }
}
