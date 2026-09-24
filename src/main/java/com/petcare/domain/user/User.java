package com.petcare.domain.user;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {
    private final UUID id;
    private String fullName;
    private String email;
    private String passwordHash;
    private final Set<Role> roles = new HashSet<>();

    public User(
            String fullName,
            String email,
            String passwordHash,
            Set<Role> roles
    ) {

        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name is required");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (passwordHash == null || passwordHash.isBlank()) {
            throw new IllegalArgumentException("Password hash is required");
        }

        if (roles == null || roles.isEmpty()) {
            throw new IllegalArgumentException("At least one role is required");
        }
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.roles.addAll(roles);
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Set<Role> getRoles() {
        return Set.copyOf(roles);
    }
}
