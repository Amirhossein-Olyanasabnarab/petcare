package com.petcare.domain.clinic;

import com.petcare.domain.user.provider.ProviderProfile;

import java.time.LocalDate;
import java.util.UUID;

public class ProviderClinic {
    private final UUID id;
    private ProviderProfile provider;
    private Clinic clinic;
    private LocalDate startDate;
    private LocalDate endDate;
    private EmploymentType employmentType;
    private ProviderClinicStatus status;


    public ProviderClinic
            (
                    ProviderProfile provider,
                    Clinic clinic,
                    LocalDate startDate,
                    EmploymentType employmentType,
                    ProviderClinicStatus status
            ){

        if (provider == null)
            throw new IllegalArgumentException("The provider is required.");

        if (clinic == null)
            throw new IllegalArgumentException("The clinic is required.");

        if (startDate == null)
            throw new IllegalArgumentException("The start date is required.");

        if (employmentType == null)
            throw new IllegalArgumentException("The employment type is required");

        if (status == null)
            throw new IllegalArgumentException("The status is required.");

        this.id = UUID.randomUUID();
        this.provider = provider;
        this.clinic = clinic;
        this.startDate = startDate;
        this.employmentType = employmentType;
        this.status = status;
    }

    public void endEmployment(LocalDate endDate) {

        if (endDate == null)
            throw new IllegalArgumentException("The end date is required.");

        if (endDate.isBefore(startDate))
            throw new IllegalArgumentException(
                    "End date cannot be before start date."
            );

        this.endDate = endDate;
        this.status = ProviderClinicStatus.ENDED;
    }

    public UUID getId() {
        return id;
    }

    public ProviderProfile getProvider() {
        return provider;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public ProviderClinicStatus getStatus() {
        return status;
    }
}
