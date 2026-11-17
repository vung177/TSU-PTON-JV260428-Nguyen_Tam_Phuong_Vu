package com.example.finalexammodule4.service;

import com.example.finalexammodule4.model.dto.request.ProductRequest;
import com.example.finalexammodule4.model.entity.Product;
import com.example.finalexammodule4.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Page<Product> getAllProducts(int page){
        return productRepository.findAll(PageRequest.of(page, 5));
    }

    public Product createProduct(ProductRequest request){
        Product product = Product.builder()
                .productName(request.getProductName())
                .price(request.getPrice())
                .currencyUnit(request.getCurrency_unit())
                .importDate(request.getImportDate())
                .warrantyPeriod(request.getWarrantyPeriod())
                .warrantyUnit(request.getWarrantyUnit())
                .description(request.getDescription())
                .status(request.getStatus())
                .build();
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, ProductRequest request){
        Product existing = productRepository.findById(id).orElseThrow(()->new NoSuchElementException("Không tìm thấy sản phẩm" +id));
        if (productRepository.existsByProductNameAndProdcutIdNot(request.getProductName(), id)){
            throw new IllegalArgumentException("Tên sản phẩm đã tồn tại");
        }
        existing.setProductName(request.getProductName());
        existing.setPrice(request.getPrice());
        existing.setCurrencyUnit(request.getCurrency_unit());
        existing.setImportDate(request.getImportDate());
        existing.setWarrantyPeriod(request.getWarrantyPeriod());
        existing.setWarrantyUnit(request.getWarrantyUnit());
        existing.setDescription(request.getDescription());
        if (request.getStatus() != null){
            existing.setStatus(request.getStatus());
        }

        return productRepository.save(existing);
    }
}
