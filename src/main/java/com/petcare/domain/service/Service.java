package com.petcare.domain.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.UUID;

public class Service {
    private final UUID id;
    private String name;
    private String description;
    private Duration duration;
    private BigDecimal basePrice;
    private BigDecimal commissionRate;

    public Service
            (
                    String name,
                    String description,
                    Duration duration,
                    BigDecimal basePrice,
                    BigDecimal commissionRate
            ) {

        if (name == null || name.isBlank())
            throw new IllegalArgumentException("The name is required.");

        if (duration == null)
            throw new IllegalArgumentException("The duration is required.");

        if (duration.isZero() || duration.isNegative())
            throw new IllegalArgumentException("Duration must be greater than zero.");

        if (basePrice == null)
            throw new IllegalArgumentException("The base price is required.");

        if (basePrice.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Base price cannot be negative.");

        if (commissionRate == null)
            throw new IllegalArgumentException("The commission rate is required.");


        if (
                commissionRate.compareTo(BigDecimal.ZERO) < 0 ||
                        commissionRate.compareTo(BigDecimal.valueOf(100)) > 0
        )
            throw new IllegalArgumentException(
                    "Commission rate must be between 0 and 100.");

        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.basePrice = basePrice;
        this.commissionRate = commissionRate;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Duration getDuration() {
        return duration;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }
}
