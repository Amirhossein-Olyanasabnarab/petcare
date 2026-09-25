package com.petcare.domain.user;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void shouldCreateUserWithValidData(){
        User user = new User
                (
                        "Amir Olya",
                        "amir@gmail.com",
                        "password",
                        Set.of(Role.CUSTOMER, Role.PROVIDER)
                );

        assertNotNull(user.getId());
        assertEquals("Amir Olya", user.getFullName());
        assertEquals("amir@gmail.com", user.getEmail());
        assertEquals("password", user.getPasswordHash());
        assertTrue(user.getRoles().contains(Role.CUSTOMER));
    }

    @Test
    void shouldRejectNullFullName(){
        assertThrows(
                IllegalArgumentException.class,
                () -> new User(
                        null,
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.CUSTOMER)
                )
        );
    }

    @Test
    void shouldRejectBlankFullName(){

        assertThrows(
                IllegalArgumentException.class,
                ()-> new User(
                        " ",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.CUSTOMER)
                )
        );
    }

    @Test
    void shouldRejectNullEmail(){
        assertThrows(
                IllegalArgumentException.class,
                ()->new User(
                        "amir h",
                        null,
                        "password_hash",
                        Set.of(Role.CUSTOMER)
                )
        );
    }

    @Test
    void shouldRejectBlankEmail(){
        assertThrows(
                IllegalArgumentException.class,
                ()->new User(
                        "amir",
                        " ",
                        "password_hash",
                        Set.of(Role.CUSTOMER)
                )
        );
    }

    @Test
    void shouldRejectNullPasswordHash(){
        assertThrows(
                IllegalArgumentException.class,
                ()->new User(
                        "amir",
                        "amir@gmail.com",
                        null,
                        Set.of(Role.CUSTOMER)
                )
        );
    }

    @Test
    void shouldRejectBlankPasswordHash(){
        assertThrows(
                IllegalArgumentException.class,
                ()->new User(
                        "amir",
                        "amir@gmail.com",
                        " ",
                        Set.of(Role.CUSTOMER)
                )
        );
    }

    @Test
    void shouldRejectUserWithoutRole(){
        assertThrows(
                IllegalArgumentException.class,
                ()->new User(
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of()
                )
        );
    }

    @Test
    void shouldAllowMultipleRoles(){
       User user = new User
               (
                       "amir",
                       "amir@gmail.com",
                       "password_hash",
                       Set.of(Role.CUSTOMER, Role.PROVIDER)
               );

       assertTrue(user.getRoles().contains(Role.CUSTOMER));
       assertTrue(user.getRoles().contains(Role.PROVIDER));
       assertEquals(2, user.getRoles().size());
    }


    @Test
    void shouldProtectRolesFromExternalModification(){
        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.CUSTOMER)
                );

        assertThrows(
                UnsupportedOperationException.class,
                ()-> user.getRoles().clear()
        );
    }
}
