package com.petcare.domain.availability;

import com.petcare.domain.location.Address;
import com.petcare.domain.location.Location;
import com.petcare.domain.service.ProviderService;
import com.petcare.domain.service.Service;
import com.petcare.domain.user.Role;
import com.petcare.domain.user.User;
import com.petcare.domain.user.provider.ProviderProfile;
import com.petcare.domain.user.provider.ProviderType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AvailabilityTest {
    @Test
    void shouldCreateAvailabilityWithValidData(){

        User user = new User
                (
                        "Amir Olya",
                        "amir@gmail.com",
                        "password",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user,
                        ProviderType.VETERINARIAN,
                        15
                );

        Service service = new Service
                (
                        "Veterinary Consultation",
                        "General veterinary consultation",
                        Duration.ofMinutes(60),
                        BigDecimal.valueOf(50),
                        BigDecimal.valueOf(10)
                );

        ProviderService providerService = new ProviderService
                (
                        provider,
                        service
                );

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

        Availability availability = new Availability
                (
                        providerService,
                        location,
                        DayOfWeek.MONDAY,
                        LocalTime.of(9, 0),
                        LocalTime.of(13, 0)
                );

        assertNotNull(availability.getId());
        assertEquals(providerService, availability.getProviderService());
        assertEquals(location, availability.getLocation());
        assertEquals(DayOfWeek.MONDAY, availability.getDayOfWeek());
        assertEquals(LocalTime.of(9, 0), availability.getStartTime());
        assertEquals(LocalTime.of(13, 0), availability.getEndTime());
    }


    @Test
    void shouldRejectNullProviderService(){

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
                        () -> new Availability
                                (
                                        null,
                                        location,
                                        DayOfWeek.MONDAY,
                                        LocalTime.of(9, 0),
                                        LocalTime.of(13, 0)
                                )
                );
    }

    @Test
    void shouldRejectNullLocation(){

        User user = new User
                (
                        "Amir Olya",
                        "amir@gmail.com",
                        "password",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user,
                        ProviderType.VETERINARIAN,
                        15
                );

        Service service = new Service
                (
                        "Veterinary Consultation",
                        "General veterinary consultation",
                        Duration.ofMinutes(60),
                        BigDecimal.valueOf(50),
                        BigDecimal.valueOf(10)
                );

        ProviderService providerService = new ProviderService
                (
                        provider,
                        service
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new Availability
                                (
                                        providerService,
                                        null,
                                        DayOfWeek.MONDAY,
                                        LocalTime.of(9, 0),
                                        LocalTime.of(13, 0)
                                )
                );
    }

    @Test
    void shouldRejectNullDayOfWeek(){

        User user = new User
                (
                        "Amir Olya",
                        "amir@gmail.com",
                        "password",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user,
                        ProviderType.VETERINARIAN,
                        15
                );

        Service service = new Service
                (
                        "Veterinary Consultation",
                        "General veterinary consultation",
                        Duration.ofMinutes(60),
                        BigDecimal.valueOf(50),
                        BigDecimal.valueOf(10)
                );

        ProviderService providerService = new ProviderService
                (
                        provider,
                        service
                );

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
                        () -> new Availability
                                (
                                        providerService,
                                        location,
                                        null,
                                        LocalTime.of(9, 0),
                                        LocalTime.of(13, 0)
                                )
                );
    }


    @Test
    void shouldRejectNullStartTime(){

        User user = new User
                (
                        "Amir Olya",
                        "amir@gmail.com",
                        "password",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user,
                        ProviderType.VETERINARIAN,
                        15
                );

        Service service = new Service
                (
                        "Veterinary Consultation",
                        "General veterinary consultation",
                        Duration.ofMinutes(60),
                        BigDecimal.valueOf(50),
                        BigDecimal.valueOf(10)
                );

        ProviderService providerService = new ProviderService
                (
                        provider,
                        service
                );

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
                        () -> new Availability
                                (
                                        providerService,
                                        location,
                                        DayOfWeek.MONDAY,
                                        null,
                                        LocalTime.of(13, 0)
                                )
                );
    }


    @Test
    void shouldRejectNullEndTime(){

        User user = new User
                (
                        "Amir Olya",
                        "amir@gmail.com",
                        "password",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user,
                        ProviderType.VETERINARIAN,
                        15
                );

        Service service = new Service
                (
                        "Veterinary Consultation",
                        "General veterinary consultation",
                        Duration.ofMinutes(60),
                        BigDecimal.valueOf(50),
                        BigDecimal.valueOf(10)
                );

        ProviderService providerService = new ProviderService
                (
                        provider,
                        service
                );

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
                        () -> new Availability
                                (
                                        providerService,
                                        location,
                                        DayOfWeek.MONDAY,
                                        LocalTime.of(9, 0),
                                        null
                                )
                );
    }

    @Test
    void shouldRejectEndTimeBeforeStartTime(){

        User user = new User
                (
                        "Amir Olya",
                        "amir@gmail.com",
                        "password",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user,
                        ProviderType.VETERINARIAN,
                        15
                );

        Service service = new Service
                (
                        "Veterinary Consultation",
                        "General veterinary consultation",
                        Duration.ofMinutes(60),
                        BigDecimal.valueOf(50),
                        BigDecimal.valueOf(10)
                );

        ProviderService providerService = new ProviderService
                (
                        provider,
                        service
                );

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
                        () -> new Availability
                                (
                                        providerService,
                                        location,
                                        DayOfWeek.MONDAY,
                                        LocalTime.of(13, 0),
                                        LocalTime.of(9, 0)
                                )
                );
    }

    @Test
    void shouldRejectEqualStartAndEndTime(){

        User user = new User
                (
                        "Amir Olya",
                        "amir@gmail.com",
                        "password",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user,
                        ProviderType.VETERINARIAN,
                        15
                );

        Service service = new Service
                (
                        "Veterinary Consultation",
                        "General veterinary consultation",
                        Duration.ofMinutes(60),
                        BigDecimal.valueOf(50),
                        BigDecimal.valueOf(10)
                );

        ProviderService providerService = new ProviderService
                (
                        provider,
                        service
                );

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
                        () -> new Availability
                                (
                                        providerService,
                                        location,
                                        DayOfWeek.MONDAY,
                                        LocalTime.of(9, 0),
                                        LocalTime.of(9, 0)
                                )
                );
    }
}
