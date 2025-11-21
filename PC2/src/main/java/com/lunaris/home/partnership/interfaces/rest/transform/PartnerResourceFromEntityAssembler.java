package com.lunaris.home.partnership.interfaces.rest.transform;

import com.lunaris.home.partnership.domain.model.aggregates.Partner;
import com.lunaris.home.partnership.interfaces.rest.resources.PartnerResource;

public class PartnerResourceFromEntityAssembler {
    public static PartnerResource toResourceFromEntity(Partner entity) {
        return new PartnerResource(
                entity.getId(),
                entity.getPartnerId().uuid(), // Extrae el String del VO LunarisPartnerId
                entity.getRepresentativeName().firstName(),
                entity.getRepresentativeName().lastName(),
                entity.getContactEmail().address(),
                entity.getContactPhone().number(),
                entity.getCompanyName(),
                entity.getCity(),
                entity.getStateOrProvince(),
                entity.getCountry()
        );
    }
}