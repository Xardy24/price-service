package com.bcnc.price_service.infrastructure.persistence;

import com.bcnc.price_service.domain.Price;
import com.bcnc.price_service.domain.port.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class PriceRepositoryAdapter implements PriceRepository {

    private final JpaPriceRepository jpaPriceRepository;

    @Autowired
    public PriceRepositoryAdapter(JpaPriceRepository jpaPriceRepository) {
        this.jpaPriceRepository = jpaPriceRepository;
    }

    @Override
    public Optional<Price> findPrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return jpaPriceRepository.findPrices(brandId, productId, applicationDate)
                .stream()
                .findFirst()
                .map(this::mapToPrice);
    }

    private Price mapToPrice(JpaPriceEntity entity) {
        return Price.builder()
                .brandId(entity.getBrandId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .priceList(entity.getPriceList())
                .productId(entity.getProductId())
                .priority(entity.getPriority())
                .price(entity.getPrice())
                .currency(entity.getCurr())
                .build();
    }
}