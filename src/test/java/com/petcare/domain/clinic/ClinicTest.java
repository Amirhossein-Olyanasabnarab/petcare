package com.petcare.domain.clinic;

import com.petcare.domain.location.Address;
import com.petcare.domain.location.Location;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ClinicTest {

    @Test
    void shouldCreateClinicWithValidData(){

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


        assertNotNull(clinic.getId());
        assertEquals("Amsterdam Pet Clinic", clinic.getName());
        assertEquals(location, clinic.getLocation());
    }

    @Test
    void shouldRejectNullName(){

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

        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new Clinic
                                (
                                        null,
                                        location
                                )
                );
    }

    @Test
    void shouldRejectBlankName(){

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

        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new Clinic
                                (
                                        " ",
                                        location
                                )
                );
    }

    @Test
    void shouldRejectNullLocation(){
        assertThrows(
                IllegalArgumentException.class,
                ()->new Clinic("Amsterdam Pet Clinic", null)
        );
    }
}
