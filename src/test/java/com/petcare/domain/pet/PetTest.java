package com.petcare.domain.pet;

import com.petcare.domain.user.CustomerProfile;
import com.petcare.domain.user.Role;
import com.petcare.domain.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PetTest {
    @Test
    void shouldCreatePetWithValidData(){
        User user = new User(
                "amir", "amir@gmail.com",
                "password_has", Set.of(Role.CUSTOMER)
        );

        CustomerProfile profile = new CustomerProfile(user);

        Pet pet = new Pet
                (
                        profile,
                        "Laika",
                        Species.DOG,
                        "Shih Tzu",
                        LocalDate.of(2023,9,16),
                        Gender.MALE,
                        "No known allergies"
                );


        assertNotNull(pet.getId());
        assertEquals(profile, pet.getOwner());
        assertEquals("Laika", pet.getName());
        assertEquals(Species.DOG, pet.getSpecies());
        assertEquals(Gender.MALE, pet.getGender());
        assertEquals("No known allergies", pet.getNotes());
        assertEquals("Shih Tzu", pet.getBreed());
        assertEquals(LocalDate.of(2023, 9, 16), pet.getDateOfBirth());
    }

    @Test
    void shouldRejectNullOwner(){
        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new Pet
                                (
                                        null,
                                        "Laika",
                                        Species.DOG,
                                        "Shih Tzu",
                                        LocalDate.of(2023,9,16),
                                        Gender.MALE,
                                        "No known allergies"
                                )
                );
    }


    @Test
    void shouldRejectBlankName(){
        User user = new User(
                "amir", "amir@gmail.com",
                "password_has", Set.of(Role.CUSTOMER)
        );

        CustomerProfile profile = new CustomerProfile(user);

        assertThrows
                (
                  IllegalArgumentException.class,
                        ()->new Pet
                                (
                                        profile,
                                        " ",
                                        Species.DOG,
                                        "Shih Tzu",
                                        LocalDate.of(2023,9,16),
                                        Gender.MALE,
                                        "No known allergies"
                                )
                );
    }

    @Test
    void shouldRejectNullSpecies(){
        User user = new User(
                "amir", "amir@gmail.com",
                "password_has", Set.of(Role.CUSTOMER)
        );

        CustomerProfile profile = new CustomerProfile(user);

        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new Pet
                                (
                                        profile,
                                        "Laika",
                                        null,
                                        "Shih Tzu",
                                        LocalDate.of(2023,9,16),
                                        Gender.MALE,
                                        "No known allergies"
                                )
                );
    }

    @Test
    void shouldRejectNullGender(){
        User user = new User(
                "amir", "amir@gmail.com",
                "password_has", Set.of(Role.CUSTOMER)
        );

        CustomerProfile profile = new CustomerProfile(user);

        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new Pet
                                (
                                        profile,
                                        "Laika",
                                        Species.DOG,
                                        "Shih Tzu",
                                        LocalDate.of(2023,9,16),
                                        null,
                                        "No known allergies"
                                )
                );
    }

    @Test
    void shouldAllowOptionalFieldsToBeNull(){
        User user = new User(
                "amir", "amir@gmail.com",
                "password_has", Set.of(Role.CUSTOMER)
        );

        CustomerProfile profile = new CustomerProfile(user);

        Pet pet = new Pet
                (
                        profile,
                        "Laika",
                        Species.DOG,
                        null,
                        null,
                        Gender.MALE,
                        null
                );

        assertNull(pet.getBreed());
        assertNull(pet.getDateOfBirth());
        assertNull(pet.getNotes());
    }
}
