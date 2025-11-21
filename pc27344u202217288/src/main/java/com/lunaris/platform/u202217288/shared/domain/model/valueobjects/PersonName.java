package com.lunaris.platform.u202217288.shared.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PersonName(String firstName, String lastName) {
    public PersonName {
        if (firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("First name and last name cannot be empty");
        }
    }
    public String getFullName() { return firstName + " " + lastName; }
}