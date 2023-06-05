package com.example.skytef.productrental.dto;

import com.example.skytef.productrental.model.ProductTypeEnum;
import lombok.Data;

@Data
public class ProductOrderByUsernameDTO {

    private ProductTypeEnum productType;
    private Integer timeHour;
    private Long productValue;
    private Long productTotal;
    private Long userAmount;
}