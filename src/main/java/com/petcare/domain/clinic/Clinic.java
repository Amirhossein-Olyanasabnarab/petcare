package com.petcare.domain.clinic;

import com.petcare.domain.location.Location;

import java.util.UUID;

public class Clinic {

    private final UUID id;
    private String name;
    private Location location;

    public Clinic(String name, Location location) {

        if (name == null || name.isBlank())
            throw new IllegalArgumentException("The name is required.");

        if (location == null)
            throw new IllegalArgumentException("The location is required.");

        this.id = UUID.randomUUID();
        this.name = name;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}
