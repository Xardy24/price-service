package com.bcnc.price_service.infrastructure.rest;

import lombok.Builder;
import lombok.Value;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
@Builder
public class PriceResponse {
    Long productId;
    Long brandId;
    Long priceList;
    LocalDateTime startDate;
    LocalDateTime endDate;
    BigDecimal price;
}