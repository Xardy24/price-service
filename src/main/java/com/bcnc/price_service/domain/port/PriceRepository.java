package com.bcnc.price_service.domain.port;

import com.bcnc.price_service.domain.Price;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {
    Optional<Price> findPrice(Long brandId, Long productId, LocalDateTime applicationDate);
}