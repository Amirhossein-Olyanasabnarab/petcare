package com.petcare.domain.user;

import com.petcare.domain.user.provider.ProviderProfile;
import com.petcare.domain.user.provider.ProviderType;
import org.junit.jupiter.api.Test;

import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class ProviderProfileTest {

    @Test
    void shouldCreateProviderProfileWithValidUser(){
        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.CUSTOMER)
                );

        ProviderProfile profile = new ProviderProfile
                (
                  user, ProviderType.VETERINARIAN, 15
                );

        assertNotNull(profile.getId());
        assertNotNull(profile.getUser());
        assertEquals(user, profile.getUser());
        assertEquals(ProviderType.VETERINARIAN, profile.getProviderType());
        assertEquals(15, profile.getServiceRadiusKm());
    }

    @Test
    void shouldRejectNullUser() {

        assertThrows(
                IllegalArgumentException.class,
                ()->new ProviderProfile(null, ProviderType.VETERINARIAN, 15)
        );
    }

    @Test
    void shouldRejectNullProviderType(){
        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.CUSTOMER)
                );


        assertThrows(
                IllegalArgumentException.class,
                ()->new ProviderProfile(user, null, 15)
        );
    }

    @Test
    void shouldRejectNegativeServiceRadiusKm(){
        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.CUSTOMER)
                );
        assertThrows(
                IllegalArgumentException.class,
                ()->new ProviderProfile(user, ProviderType.VETERINARIAN, -10)
        );
    }

    @Test
    void shouldAllowZeroServiceRadiusKm(){
        User user = new User(
                "amir",
                "amir@gmail.com",
                "password_hash",
                Set.of(Role.PROVIDER)
        );

        ProviderProfile profile = new ProviderProfile(
                user,
                ProviderType.VETERINARIAN,
                0
        );

        assertEquals(0, profile.getServiceRadiusKm());
    }
}
