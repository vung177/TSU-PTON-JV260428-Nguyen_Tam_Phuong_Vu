package com.example.finalexammodule4.respository;

import com.example.finalexammodule4.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByProductName(String productName);
    boolean existsByProductNameAndProdcutIdNot(String productName, Integer productId);
    List<Product> findByNameContainingIgnoreCase(String productName, Integer productId);
    List<Product> findByStatus(Byte status);
}
