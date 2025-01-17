package com.bcnc.price_service.application;

import com.bcnc.price_service.domain.Price;
import com.bcnc.price_service.domain.port.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<Price> findPrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return priceRepository.findPrice(brandId, productId, applicationDate);
    }
}