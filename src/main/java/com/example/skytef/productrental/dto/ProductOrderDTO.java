package com.example.skytef.productrental.dto;

import com.example.skytef.productrental.model.ProductTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductOrderDTO {

    @NotNull
    private String userName;

    @NotNull
    private ProductTypeEnum productType;

    @NotNull
    private Integer timeHour;
}
