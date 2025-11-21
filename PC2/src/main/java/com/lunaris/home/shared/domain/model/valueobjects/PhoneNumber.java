package com.lunaris.home.shared.domain.model.valueobjects;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;


@Embeddable
public record PhoneNumber(@Pattern(regexp = "^\\+?[0-9\\s-]{7,15}$", message = "Invalid phone number format")String number) {
    public PhoneNumber {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be null or blank");
        }
    }
}
