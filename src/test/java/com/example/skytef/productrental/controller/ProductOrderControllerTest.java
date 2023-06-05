package com.example.skytef.productrental.controller;

import com.example.skytef.productrental.ProductRentalApplicationTests;
import com.example.skytef.productrental.model.ProductTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.util.UriComponentsBuilder.fromPath;

class ProductOrderControllerTest extends ProductRentalApplicationTests {

    @Test
    public void shouldReturnCreatedWhenCreateProductOrder() throws Exception {
        String uri = fromPath("/orders").toUriString();

        mockMvc.perform(post(uri)
                        .content(getContentFromResource("/json/create-product-order.json"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnOkWhenGetProductOrderByUsername() throws Exception {
        String uri = fromPath("/orders/username").toUriString();

        mockMvc.perform(get(uri)
                        .param("username", "tico"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$[0].productType").value(ProductTypeEnum.CAMERA.name()))
                .andExpect(jsonPath("$[0].timeHour").value(14))
                .andExpect(jsonPath("$[0].productValue").value(5000))
                .andExpect(jsonPath("$[0].productTotal").value(60000))
                .andExpect(jsonPath("$[0].userAmount").value(9360))
                .andExpect(jsonPath("$[1].productType").value(ProductTypeEnum.CAMERA.name()))
                .andExpect(jsonPath("$[1].timeHour").value(3))
                .andExpect(jsonPath("$[1].productValue").value(5000))
                .andExpect(jsonPath("$[1].productTotal").value(15000))
                .andExpect(jsonPath("$[1].userAmount").value(2340));
    }

    @Test
    public void shouldReturnNotFoundWhenGetProductOrderByNotExistingUsername() throws Exception {
        String uri = fromPath("/orders/username").toUriString();

        mockMvc.perform(get(uri)
                        .param("username", "wrong"))
                .andExpect(status().isNotFound());
    }
}