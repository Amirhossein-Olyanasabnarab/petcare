package com.petcare.domain.user.provider;

import com.petcare.domain.user.User;

import java.util.UUID;

public class ProviderProfile {
    private final UUID id;
    private User user;
    private ProviderType providerType;
    private double serviceRadiusKm;

    public ProviderProfile(
            User user,
            ProviderType providerType,
            double serviceRadiusKm
    ) {

        if (user == null)
            throw new IllegalArgumentException("User is required");

        if (providerType == null)
            throw new IllegalArgumentException("Provider Type is required.");

        if (serviceRadiusKm < 0)
            throw new IllegalArgumentException("Service radius cannot be negative.");


        this.id = UUID.randomUUID();
        this.user = user;
        this.providerType = providerType;
        this.serviceRadiusKm = serviceRadiusKm;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public ProviderType getProviderType() {
        return providerType;
    }

    public double getServiceRadiusKm() {
        return serviceRadiusKm;
    }
}
