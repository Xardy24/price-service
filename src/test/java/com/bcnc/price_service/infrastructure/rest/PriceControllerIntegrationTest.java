package com.bcnc.price_service.infrastructure.rest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test 1: Request at 10:00 on day 14 - Product 35455 - Brand 1 (ZARA)")
    void test1_priceAt_2020_06_14_10_00() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(1)))
                .andExpect(jsonPath("$.startDate", is("2020-06-14T00:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.price", is(35.50)));
    }

    @Test
    @DisplayName("Test 2: Request at 16:00 on day 14 - Product 35455 - Brand 1 (ZARA)")
    void test2_priceAt_2020_06_14_16_00() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T16:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(2)))
                .andExpect(jsonPath("$.startDate", is("2020-06-14T15:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-06-14T18:30:00")))
                .andExpect(jsonPath("$.price", is(25.45)));
    }

    @Test
    @DisplayName("Test 3: Request at 21:00 on day 14 - Product 35455 - Brand 1 (ZARA)")
    void test3_priceAt_2020_06_14_21_00() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(1)))
                .andExpect(jsonPath("$.startDate", is("2020-06-14T00:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.price", is(35.50)));
    }

    @Test
    @DisplayName("Test 4: Request at 10:00 on day 15 - Product 35455 - Brand 1 (ZARA)")
    void test4_priceAt_2020_06_15_10_00() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-15T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(3)))
                .andExpect(jsonPath("$.startDate", is("2020-06-15T00:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-06-15T11:00:00")))
                .andExpect(jsonPath("$.price", is(30.50)));
    }

    @Test
    @DisplayName("Test 5: Request at 21:00 on day 16 - Product 35455 - Brand 1 (ZARA)")
    void test5_priceAt_2020_06_16_21_00() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-16T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(4)))
                .andExpect(jsonPath("$.startDate", is("2020-06-15T16:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.price", is(38.95)));
    }
}