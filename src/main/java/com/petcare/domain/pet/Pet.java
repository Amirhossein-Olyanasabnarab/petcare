package com.petcare.domain.pet;

import com.petcare.domain.user.CustomerProfile;

import java.time.LocalDate;
import java.util.UUID;

public class Pet {
    private final UUID id;
    private CustomerProfile owner;
    private String name;
    private Species species;
    private String breed;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String notes;

    public Pet(
            CustomerProfile owner,
            String name,
            Species species,
            String breed,
            LocalDate dateOfBirth,
            Gender gender,
            String notes
    ){

        if (owner == null)
            throw new IllegalArgumentException("The owner is required.");

        if (name == null || name.isBlank())
            throw new IllegalArgumentException("The name is required");

        if (species == null )
            throw new IllegalArgumentException("The species is required");

        if (gender == null )
            throw new IllegalArgumentException("The gender is required");



        this.id = UUID.randomUUID();
        this.owner = owner;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.notes = notes;
    }

    public UUID getId() {
        return id;
    }

    public CustomerProfile getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public Species getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getNotes() {
        return notes;
    }
}
