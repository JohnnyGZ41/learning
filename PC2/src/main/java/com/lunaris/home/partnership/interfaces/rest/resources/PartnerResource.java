package com.lunaris.home.partnership.interfaces.rest.resources;

public record PartnerResource(
        Integer id,
        String partnerId, // UUID como String
        String representativeFirstName,
        String representativeLastName,
        String contactEmail,
        String contactPhone,
        String companyName,
        String city,
        String stateOrProvince,
        String country
) {
}