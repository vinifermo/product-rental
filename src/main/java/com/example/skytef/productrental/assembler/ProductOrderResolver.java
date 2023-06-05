package com.example.skytef.productrental.assembler;

import com.example.skytef.productrental.dto.ProductOrderDTO;
import com.example.skytef.productrental.factory.ProductStrategy;
import lombok.Getter;

@Getter
public class ProductOrderResolver {

    private final Long totalValue;
    private final Long userAmount;
    private final Long productValue;

    public ProductOrderResolver(ProductOrderDTO productOrderDTO, ProductStrategy product) {
        this.productValue = calculateProductValue(product.productValue());
        this.totalValue = calculateTotalValue(productOrderDTO.getTimeHour(), product.productValue());
        this.userAmount = calculateUserAmount(productOrderDTO.getTimeHour(), product.productValue(), product.userValue());
    }

    private Long calculateProductValue(Long productValue) {
        return productValue * 100;
    }

    private Long calculateTotalValue(Integer timeHour, Long productValue) {
        return (timeHour * calculateProductValue(productValue));
    }

    private Long calculateUserAmount(Integer timeHour, Long productValue, Double userValue) {
        Double userAmount = calculateTotalValue(timeHour, productValue) * (userValue / 100);
        return userAmount.longValue();
    }
}
