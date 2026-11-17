package com.example.finalexammodule4.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductRequest {
    @NotNull(message = "Tên sản phẩm không được để trống hoặc chỉ chứa khoảng trắng!")
    @Size(max = 100)
    private String productName;

    @NotNull(message = "Giá sản phẩm là trường bắt buộc!")
    @Min(value = 1, message = "Giá sản phẩm phải lớn hơn 0!")
    private Double price;

    @NotNull
    @Size(max = 10)
    private String currency_unit;

    @NotNull
    private LocalDate importDate;

    @NotNull
    private Integer warrantyPeriod;

    @NotNull
    @Size(max = 10)
    private String warrantyUnit;

    @NotNull
    @Size(max = 255)
    private String description;

    private Byte status;
}
