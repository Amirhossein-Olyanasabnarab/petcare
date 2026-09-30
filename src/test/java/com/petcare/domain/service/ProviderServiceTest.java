package com.petcare.domain.service;

import com.petcare.domain.user.Role;
import com.petcare.domain.user.User;
import com.petcare.domain.user.provider.ProviderProfile;
import com.petcare.domain.user.provider.ProviderType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ProviderServiceTest {

    @Test
    void shouldCreateProviderServiceWithValidData(){
        User user = new User
                (
                        "Amir Olya",
                        "amir@gmail.com",
                        "password",
                        Set.of(Role.PROVIDER)
                );
        ProviderProfile provider = new ProviderProfile
                (
                        user, ProviderType.VETERINARIAN, 15
                );
        Service service = new Service
                (
                        "Grooming",
                        "Grooming and take a shower your pet",
                        Duration.ofMinutes(120),
                        BigDecimal.valueOf(50),
                        BigDecimal.valueOf(10)
                );
        ProviderService providerService = new ProviderService
                (provider, service);

        assertNotNull(providerService.getId());
        assertEquals(provider, providerService.getProvider());
        assertEquals(service, providerService.getService());
    }

    @Test
    void shouldRejectNullProvider(){
        Service service = new Service
                (
                        "Grooming",
                        "Grooming and take a shower your pet",
                        Duration.ofMinutes(120),
                        BigDecimal.valueOf(50),
                        BigDecimal.valueOf(10)
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new ProviderService(null, service)
                );
    }

    @Test
    void shouldRejectNullService(){
        User user = new User
                (
                        "Amir Olya",
                        "amir@gmail.com",
                        "password",
                        Set.of(Role.PROVIDER)
                );
        ProviderProfile provider = new ProviderProfile
                (
                        user, ProviderType.VETERINARIAN, 15
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new ProviderService(provider, null)
                );
    }
}
