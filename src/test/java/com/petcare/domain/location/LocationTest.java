package com.petcare.domain.location;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {

    @Test
    void shouldCreateLocationWithValidData() {

        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(52.3676),
                        BigDecimal.valueOf(4.9041)
                );

        assertNotNull(location.getId());
        assertEquals(address, location.getAddress());
        assertEquals(BigDecimal.valueOf(52.3676), location.getLatitude());
        assertEquals(BigDecimal.valueOf(4.9041), location.getLongitude());
    }

    @Test
    void shouldRejectNullAddress() {
        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Location
                                (
                                        null,
                                        BigDecimal.valueOf(52.3676),
                                        BigDecimal.valueOf(4.9041)
                                )
                );
    }

    @Test
    void shouldRejectNullLatitude() {

        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Location
                                (
                                        address,
                                        null,
                                        BigDecimal.valueOf(4.9041)
                                )
                );
    }

    @Test
    void shouldRejectLatitudeBelowMinus90() {
        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Location
                                (
                                        address,
                                        BigDecimal.valueOf(-91),
                                        BigDecimal.valueOf(4.9041)
                                )
                );
    }

    @Test
    void shouldRejectLatitudeAbove90() {
        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Location
                                (
                                        address,
                                        BigDecimal.valueOf(91),
                                        BigDecimal.valueOf(4.9041)
                                )
                );
    }

    @Test
    void shouldAllowLatitudeMinus90() {
        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(-90),
                        BigDecimal.valueOf(4.9041)
                );

        assertEquals(BigDecimal.valueOf(-90), location.getLatitude());
    }

    @Test
    void shouldAllowLatitude90() {
        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(90),
                        BigDecimal.valueOf(4.9041)
                );

        assertEquals(BigDecimal.valueOf(90), location.getLatitude());
    }

    @Test
    void shouldRejectNullLongitude() {

        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Location
                                (
                                        address,
                                        BigDecimal.valueOf(52.3676),
                                        null
                                )
                );
    }

    @Test
    void shouldRejectLongitudeBelowMinus180() {

        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Location
                                (
                                        address,
                                        BigDecimal.valueOf(52.3676),
                                        BigDecimal.valueOf(-181)
                                )
                );
    }

    @Test
    void shouldAllowLongitudeMinus180() {
        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(52.3676),
                        BigDecimal.valueOf(-180)
                );

        assertEquals(BigDecimal.valueOf(-180), location.getLongitude());
    }

    @Test
    void shouldAllowLongitude180() {
        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(52.3676),
                        BigDecimal.valueOf(180)
                );

        assertEquals(BigDecimal.valueOf(180), location.getLongitude());
    }

    @Test
    void shouldRejectLongitudeAbove180() {

        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Location
                                (
                                        address,
                                        BigDecimal.valueOf(52.3676),
                                        BigDecimal.valueOf(181)
                                )
                );
    }
}
