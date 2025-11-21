package com.lunaris.home.partnership.interfaces.rest.transform;

import com.lunaris.home.partnership.domain.model.commands.CreatePartnerCommand;
import com.lunaris.home.partnership.interfaces.rest.resources.CreatePartnerResource;

public class CreatePartnerCommandFromResourceAssembler {
    public static CreatePartnerCommand toCommandFromResource(CreatePartnerResource resource) {
        return new CreatePartnerCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.phoneNumber(),
                resource.companyName(),
                resource.city(),
                resource.stateOrProvince(),
                resource.country()
        );
    }
}