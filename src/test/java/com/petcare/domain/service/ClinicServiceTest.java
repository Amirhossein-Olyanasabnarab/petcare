package com.petcare.domain.service;

import com.petcare.domain.clinic.Clinic;
import com.petcare.domain.location.Address;
import com.petcare.domain.location.Location;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ClinicServiceTest {

    @Test
    void shouldCreateClinicServiceWithValidData(){
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

        Clinic clinic = new Clinic
                (
                        "Amsterdam Pet Clinic",
                        location
                );
        Service service = new Service
                (
                        "Grooming",
                        "Grooming and bathing for your pet",
                        Duration.ofMinutes(120),
                        BigDecimal.valueOf(50),
                        BigDecimal.valueOf(10)
                );

        ClinicService clinicService = new ClinicService
                (clinic, service);

        assertNotNull(clinicService.getId());
        assertEquals(clinic, clinicService.getClinic());
        assertEquals(service, clinicService.getService());
    }

    @Test
    void shouldRejectNullClinic(){
        Service service = new Service
                (
                        "Grooming",
                        "Grooming and bathing for your pet",
                        Duration.ofMinutes(120),
                        BigDecimal.valueOf(50),
                        BigDecimal.valueOf(10)
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new ClinicService(null, service)
                );
    }

    @Test
    void shouldRejectNullService(){
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

        Clinic clinic = new Clinic
                (
                        "Amsterdam Pet Clinic",
                        location
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new ClinicService(clinic, null)
                );
    }
}
