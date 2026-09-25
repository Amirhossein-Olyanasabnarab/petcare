package com.petcare.domain.user;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerProfileTest {

    @Test
    void shouldCreateCustomerProfileWithValidUser() {
        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.CUSTOMER)
                );
        CustomerProfile profile = new CustomerProfile(user);

        assertNotNull(profile.getId());
        assertEquals(user, profile.getUser());
    }

    @Test
    void shouldRejectNullUser(){
        User user = null;
        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new CustomerProfile(user)
                );
    }
}
