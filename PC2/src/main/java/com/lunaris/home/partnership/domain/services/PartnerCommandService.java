package com.lunaris.home.partnership.domain.services;

import com.lunaris.home.partnership.domain.model.aggregates.Partner;
import com.lunaris.home.partnership.domain.model.commands.CreatePartnerCommand;

import java.util.Optional;

public interface PartnerCommandService {
    /**
     * Handle Create Partner Command
     * @param command The CreatePartnerCommand containing partner data
     * @return Optional containing the created Partner if successful
     */
    Optional<Partner> handle(CreatePartnerCommand command);
}