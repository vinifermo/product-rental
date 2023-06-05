package com.example.skytef.productrental.assembler;

import com.example.skytef.productrental.dto.ProductOrderByUsernameDTO;
import com.example.skytef.productrental.dto.ProductOrderDTO;
import com.example.skytef.productrental.factory.ProductFactory;
import com.example.skytef.productrental.factory.ProductStrategy;
import com.example.skytef.productrental.model.ProductOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductOrderAssembler {
    public ProductOrder toEntity(ProductOrderDTO productOrderDTO) {
        ProductOrder productOrder = new ProductOrder();

        ProductStrategy product = ProductFactory.getFactory(productOrderDTO);
        ProductOrderResolver productResolver = new ProductOrderResolver(productOrderDTO, product);

        productOrder.setUserName(productOrderDTO.getUserName());
        productOrder.setProductType(productOrderDTO.getProductType());
        productOrder.setTimeHour(productOrderDTO.getTimeHour());
        productOrder.setProductValue(productResolver.getProductValue());
        productOrder.setProductTotal(productResolver.getTotalValue());
        productOrder.setUserAmount(productResolver.getUserAmount());

        return productOrder;
    }

    public List<ProductOrderByUsernameDTO> toModel(List<ProductOrder> productOrderByUsername) {

        return productOrderByUsername.stream()
                .map(productOrder -> {
                    ProductOrderByUsernameDTO productOrderByUsernameDTO = new ProductOrderByUsernameDTO();
                    productOrderByUsernameDTO.setProductType(productOrder.getProductType());
                    productOrderByUsernameDTO.setTimeHour(productOrder.getTimeHour());
                    productOrderByUsernameDTO.setProductTotal(productOrder.getProductTotal());
                    productOrderByUsernameDTO.setProductValue(productOrder.getProductValue());
                    productOrderByUsernameDTO.setUserAmount(productOrder.getUserAmount());

                    return productOrderByUsernameDTO;
                })
                .collect(Collectors.toList());
    }
}