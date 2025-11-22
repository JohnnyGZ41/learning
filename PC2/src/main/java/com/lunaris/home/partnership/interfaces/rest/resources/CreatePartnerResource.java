package com.lunaris.home.partnership.interfaces.rest.resources;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreatePartnerResource(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank @Email String email,
        @NotBlank String phoneNumber,
        @NotBlank String companyName,
        @NotBlank String city,
        String stateOrProvince, // Opcional
        @NotBlank String country
) {
}