package com.petcare.domain.service;

import com.petcare.domain.user.provider.ProviderProfile;

import java.util.UUID;

public class ProviderService {
    private final UUID id;
    private ProviderProfile provider;
    private Service service;

    public ProviderService(
            ProviderProfile provider,
            Service service
    ) {

        if (provider == null)
            throw new IllegalArgumentException("The provider is required.");

        if (service == null)
            throw new IllegalArgumentException("The service is required.");

        this.id = UUID.randomUUID();
        this.provider = provider;
        this.service = service;
    }

    public UUID getId() {
        return id;
    }

    public ProviderProfile getProvider() {
        return provider;
    }

    public Service getService() {
        return service;
    }
}
