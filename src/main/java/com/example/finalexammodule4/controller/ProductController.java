package com.example.finalexammodule4.controller;

import com.example.finalexammodule4.model.dto.request.ProductRequest;
import com.example.finalexammodule4.model.dto.response.ApiResponse;
import com.example.finalexammodule4.model.entity.Product;
import com.example.finalexammodule4.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Product>> create(@Valid @RequestBody ProductRequest request) {
     Product created = productService.createProduct(request);
     return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.of(201, "Thêm mới sản phẩm thành công", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> update(@PathVariable Integer id, @Valid @RequestBody ProductRequest request) {
        Product updated = productService.updateProduct(id, request);
        return ResponseEntity.ok(ApiResponse.of(200, "Cập nhật sản phẩm thành công", updated));
    }
}
