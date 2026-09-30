package com.petcare.domain.availability;

import com.petcare.domain.location.Location;
import com.petcare.domain.service.ProviderService;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

public class Availability {

    private final UUID id;
    private ProviderService providerService;
    private Location location;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public Availability(
            ProviderService providerService,
            Location location,
            DayOfWeek dayOfWeek,
            LocalTime startTime,
            LocalTime endTime
    ) {

        if (providerService == null)
            throw new IllegalArgumentException("The provider service is required.");

        if (location == null)
            throw new IllegalArgumentException("The location is required.");

        if (dayOfWeek == null)
            throw new IllegalArgumentException("The day of week is required.");

        if (startTime == null)
            throw new IllegalArgumentException("The start time is required.");

        if (endTime == null)
            throw new IllegalArgumentException("The end time is required.");

        if (!endTime.isAfter(startTime))
            throw new IllegalArgumentException(
                    "End time must be after start time."
            );

        this.id = UUID.randomUUID();
        this.providerService = providerService;
        this.location = location;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public UUID getId() {
        return id;
    }

    public ProviderService getProviderService() {
        return providerService;
    }

    public Location getLocation() {
        return location;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
