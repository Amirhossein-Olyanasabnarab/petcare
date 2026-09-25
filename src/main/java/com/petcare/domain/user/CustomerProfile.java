package com.petcare.domain.user;

import java.util.UUID;

public class CustomerProfile {

    private final UUID id;
    private final User user;

    public CustomerProfile(User user){

        if (user == null){
            throw new IllegalArgumentException("User is required");
        }
        this.id = UUID.randomUUID();
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}
