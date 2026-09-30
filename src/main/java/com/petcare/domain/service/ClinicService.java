package com.petcare.domain.service;

import com.petcare.domain.clinic.Clinic;

import java.util.UUID;

public class ClinicService {
    private final UUID id;
    private Clinic clinic;
    private Service service;

    public ClinicService(
            Clinic clinic,
            Service service
    ) {

        if (clinic == null)
            throw new IllegalArgumentException("The clinic is required.");

        if (service == null)
            throw new IllegalArgumentException("The service is required.");

        this.id = UUID.randomUUID();
        this.clinic = clinic;
        this.service = service;
    }

    public UUID getId() {
        return id;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public Service getService() {
        return service;
    }
}
