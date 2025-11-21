package com.lunaris.platform.u202217288.partnership.interfaces.rest.resources;

public record PartnerResource(
        Long id, String partnerId, String representativeFirstName,
        String representativeLastName, String contactEmail, String contactPhone,
        String companyName, String city, String stateOrProvince, String country
) {}