package com.lunaris.platform.u202217288.partnership.interfaces.rest.resources;

public record CreatePartnerResource(
        String firstName, String lastName, String contactEmail,
        String contactPhone, String companyName, String city,
        String stateOrProvince, String country
) {}