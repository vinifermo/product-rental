package com.example.skytef.productrental.controller;

import com.example.skytef.productrental.dto.ProductOrderByUsernameDTO;
import com.example.skytef.productrental.dto.ProductOrderDTO;
import com.example.skytef.productrental.service.ProductOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@Valid @RequestBody ProductOrderDTO productOrderDTO) {
        productOrderService.createOrder(productOrderDTO);
    }

    @GetMapping("/username")
    public List<ProductOrderByUsernameDTO> getOrderByUsername(@RequestParam String username) {
        return productOrderService.getByUsername(username);
    }
}
