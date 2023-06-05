package com.example.skytef.productrental.service;

import com.example.skytef.productrental.assembler.ProductOrderAssembler;
import com.example.skytef.productrental.dto.ProductOrderByUsernameDTO;
import com.example.skytef.productrental.dto.ProductOrderDTO;
import com.example.skytef.productrental.model.ProductOrder;
import com.example.skytef.productrental.repository.ProductOrderRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.skytef.productrental.exception.CustomExceptionHandler.NULL_POINTER_EXCEPTION;
import static com.example.skytef.productrental.exception.CustomExceptionHandler.PRODUCT_ORDER_NOT_FOUND_FOR_THIS_USERNAME;

@Service
@RequiredArgsConstructor
public class ProductOrderService {

    private final ProductOrderRepository productOrderRepository;
    private final ProductOrderAssembler productAssembler;

    @Transactional
    public ProductOrder createOrder(ProductOrderDTO productOrderDTO) {
        ProductOrder productOrder = productAssembler.toEntity(productOrderDTO);
        return productOrderRepository.save(productOrder);
    }

    public List<ProductOrderByUsernameDTO> getByUsername(String username) {
        try {
            List<ProductOrder> productOrderByUsername = productOrderRepository.findByUserNameIgnoreCase(username);
            if (productOrderByUsername.isEmpty()) {
                throw new EntityNotFoundException(String.format(PRODUCT_ORDER_NOT_FOUND_FOR_THIS_USERNAME, username));
            } else {
                return productAssembler.toModel(productOrderByUsername);
            }
        } catch (NullPointerException e) {
            throw new RuntimeException(NULL_POINTER_EXCEPTION, e);
        }
    }
}
