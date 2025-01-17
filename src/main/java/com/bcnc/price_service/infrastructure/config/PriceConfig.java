package com.bcnc.price_service.infrastructure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {
    "com.example.prices.infrastructure",
    "com.example.prices.application",
    "com.example.prices.domain"
})
@EnableJpaRepositories(basePackages = "com.example.prices.infrastructure.persistence")
public class PriceConfig {
}