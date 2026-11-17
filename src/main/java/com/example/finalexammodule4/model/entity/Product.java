package com.example.finalexammodule4.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "product_id")
        private Integer productId;

        @Column(name = "product_name", length = 100, nullable = false, unique = true)
        private String productName;

        @Column(name = "price", nullable = false)
        private Double price;

        @Column(name = "currency_unit", length = 10, nullable = false)
        private String currencyUnit;

        @Column(name = "import_date", nullable = false)
        private LocalDate importDate;

        @Column(name = "warranty_period", length = 10, nullable = false)
        private Integer warrantyPeriod;

        @Column(name = "warranty_unit", length = 10, nullable = false)
        private String warrantyUnit;

        @Column(name = "product_image", length = 255, nullable = false)
        private String productImage;

        @Column(name = "description", length = 255, nullable = false)
        private String description;

        @Column(name = "status", columnDefinition = "TINYINT default 1")
        private Byte status;

        @PrePersist
        public void prePersist() {
                if (this.status == null) {
                        this.status = 1; // 1 - running, 2 - stop running
                }
        }
}
