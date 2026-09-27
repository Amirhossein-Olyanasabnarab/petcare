package com.petcare.domain.location;

import java.math.BigDecimal;
import java.util.UUID;

public class Location {

    private final UUID id;
    private Address address;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public Location
            (
                    Address address,
                    BigDecimal latitude,
                    BigDecimal longitude
            ) {

        if (address == null)
            throw new IllegalArgumentException("The address is required.");

        if (latitude == null)
            throw new IllegalArgumentException("The latitude is required.");

        if (
                latitude.compareTo(BigDecimal.valueOf(-90)) < 0 ||
                        latitude.compareTo(BigDecimal.valueOf(90)) > 0
        )
            throw new IllegalArgumentException(
                    "Latitude must be between -90 and 90."
            );

        if (longitude == null)
            throw new IllegalArgumentException("The longitude is required.");

        if (
                longitude.compareTo(BigDecimal.valueOf(-180)) < 0 ||
                        longitude.compareTo(BigDecimal.valueOf(180)) > 0
        )
            throw new IllegalArgumentException(
                    "Longitude must be between -180 and 180."
            );


        this.id = UUID.randomUUID();
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public UUID getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }
}
