package com.lunaris.platform.u202217288.partnership.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public record LunarisPartnerId(String partnerId) {
    public LunarisPartnerId() { this(UUID.randomUUID().toString()); }

    public LunarisPartnerId {
        if (partnerId == null || partnerId.isBlank()) {
            throw new IllegalArgumentException("Partner ID cannot be empty");
        }
    }
}