package org.example.codeshadowing.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.codeshadowing.dto.ProductRequestDto;
import org.example.codeshadowing.dto.ProductResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequest request) {
        ProductResponseDto response = productService.createProduct(request);
        return ResponseEntity.created(URI.create("/api/products/" + response.getId())).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getProduct(){
        return ResponseEntity.ok(productService.getProduct());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id,
                                                            @Valid @RequestBody ProductRequestDto request){
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
