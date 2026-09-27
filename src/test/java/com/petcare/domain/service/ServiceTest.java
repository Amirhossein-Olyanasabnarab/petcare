package com.petcare.domain.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    @Test
    void shouldCreateServiceWithValidData() {
        Service service = new Service
                (
                        "Grooming",
                        "Grooming and take a shower your pet",
                        Duration.ofMinutes(120L),
                        BigDecimal.valueOf(50),
                        BigDecimal.valueOf(10)
                );

        assertNotNull(service.getId());
        assertEquals("Grooming", service.getName());
        assertEquals(
                "Grooming and take a shower your pet",
                service.getDescription()
        );
        assertEquals(Duration.ofMinutes(120), service.getDuration());
        assertEquals(BigDecimal.valueOf(50), service.getBasePrice());
        assertEquals(BigDecimal.valueOf(10), service.getCommissionRate());
    }

    @Test
    void shouldRejectNullName() {

        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Service
                                (
                                        null,
                                        "Grooming and take a shower your pet",
                                        Duration.ofMinutes(120L),
                                        BigDecimal.valueOf(50),
                                        BigDecimal.valueOf(10)
                                )
                );
    }

    @Test
    void shouldRejectBlankName() {
        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Service
                                (
                                        " ",
                                        "Grooming and take a shower your pet",
                                        Duration.ofMinutes(120L),
                                        BigDecimal.valueOf(50),
                                        BigDecimal.valueOf(10)
                                )
                );
    }


    @Test
    void shouldRejectNullDuration() {
        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Service
                                (
                                        "Grooming",
                                        "Grooming and take a shower your pet",
                                        null,
                                        BigDecimal.valueOf(50),
                                        BigDecimal.valueOf(10)
                                )
                );
    }


    @Test
    void shouldRejectZeroDuration() {
        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Service
                                (
                                        "Grooming",
                                        "Grooming and take a shower your pet",
                                        Duration.ZERO,
                                        BigDecimal.valueOf(50),
                                        BigDecimal.valueOf(10)
                                )
                );
    }

    @Test
    void shouldRejectNegativeDuration() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Service
                        (
                                "Grooming",
                                "Grooming and take a shower your pet",
                                Duration.ofMinutes(-30),
                                BigDecimal.valueOf(50),
                                BigDecimal.valueOf(10)
                        )
        );
    }

    @Test
    void shouldRejectNullBasePrice() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Service(
                        "Grooming",
                        "Grooming and take a shower your pet",
                        Duration.ofMinutes(120),
                        null,
                        BigDecimal.valueOf(10)
                )
        );
    }

    @Test
    void shouldRejectNegativeBasePrice() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Service(
                        "Grooming",
                        "Grooming and take a shower your pet",
                        Duration.ofMinutes(120),
                        BigDecimal.valueOf(-10),
                        BigDecimal.valueOf(10)
                )
        );
    }

    @Test
    void shouldAllowZeroBasePrice() {
        Service service = new Service(
                "Grooming",
                "Grooming and take a shower your pet",
                Duration.ofMinutes(120),
                BigDecimal.ZERO,
                BigDecimal.valueOf(10)
        );

        assertEquals(BigDecimal.ZERO, service.getBasePrice());
    }

    @Test
    void shouldRejectNullCommissionRate() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Service(
                        "Grooming",
                        "Grooming and take a shower your pet",
                        Duration.ofMinutes(120),
                        BigDecimal.valueOf(50),
                        null
                )
        );
    }

    @Test
    void shouldRejectNegativeCommissionRate() {
        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Service(
                                "Grooming",
                                "Grooming and take a shower your pet",
                                Duration.ofMinutes(120),
                                BigDecimal.valueOf(50),
                                BigDecimal.valueOf(-5)
                        )
                );
    }

    @Test
    void shouldRejectCommissionRateAbove100() {
        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Service(
                                "Grooming",
                                "Grooming and take a shower your pet",
                                Duration.ofMinutes(120),
                                BigDecimal.valueOf(50),
                                BigDecimal.valueOf(101)
                        )
                );
    }

    @Test
    void shouldAllowZeroCommissionRate() {
        Service service = new Service
                (
                        "Grooming",
                        "Grooming and take a shower your pet",
                        Duration.ofMinutes(120),
                        BigDecimal.valueOf(50),
                        BigDecimal.ZERO
                );

        assertEquals(BigDecimal.ZERO, service.getCommissionRate());
    }

    @Test
    void shouldAllow100PercentCommission(){
        Service service = new Service
                (
                        "Grooming",
                        "Grooming and take a shower your pet",
                        Duration.ofMinutes(120),
                        BigDecimal.valueOf(50),
                        BigDecimal.valueOf(100)
                );
        assertEquals(BigDecimal.valueOf(100), service.getCommissionRate());
    }
}
