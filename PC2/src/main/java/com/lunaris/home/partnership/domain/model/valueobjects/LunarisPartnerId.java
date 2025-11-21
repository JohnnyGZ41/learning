package com.lunaris.home.partnership.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record LunarisPartnerId(String uuid) {

    public LunarisPartnerId(){
        this(UUID.randomUUID().toString());
    }
    public LunarisPartnerId{
        if (uuid == null || uuid.isBlank()) {
            throw new IllegalArgumentException("Partner record id cannot be null or empty");
        }
    }
}
