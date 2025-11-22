package com.lunaris.home.partnership.domain.model.commands;

public record CreatePartnerCommand(String firstName,
                                   String lastName,
                                   String email,
                                   String phoneNumber,
                                   String companyName,
                                   String city,
                                   String stateOrProvince,
                                   String country
) {
    public CreatePartnerCommand {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be null or blank");
        }
        if (companyName == null || companyName.isBlank()) {
            throw new IllegalArgumentException("Company name cannot be null or blank");
        }
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be null or blank");
        }
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country cannot be null or blank");
        }
    }
}
