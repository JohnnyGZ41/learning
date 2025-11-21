package com.lunaris.platform.u202217288.partnership.interfaces.rest;

import com.lunaris.platform.u202217288.partnership.domain.model.aggregates.Partner;
import com.lunaris.platform.u202217288.partnership.infrastructure.persistence.jpa.repositories.PartnerRepository;
import com.lunaris.platform.u202217288.partnership.interfaces.rest.resources.CreatePartnerResource;
import com.lunaris.platform.u202217288.partnership.interfaces.rest.resources.PartnerResource;
import com.lunaris.platform.u202217288.shared.domain.model.valueobjects.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/partners")
@Tag(name = "Partners", description = "Operations for Partners")
public class PartnerController {

    private final PartnerRepository partnerRepository;

    public PartnerController(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @PostMapping
    public ResponseEntity<?> createPartner(@RequestBody CreatePartnerResource resource) {
        // 1. Validar Regla de Negocio (Unicidad)
        if (partnerRepository.existsByRepresentativeName_FirstNameAndRepresentativeName_LastNameAndCompanyNameAndCountry(
                resource.firstName(), resource.lastName(), resource.companyName(), resource.country())) {
            return ResponseEntity.badRequest().body("Partner representative already exists for this company in this country");
        }

        try {
            // 2. Crear Entidad
            Partner partner = new Partner(
                    new PersonName(resource.firstName(), resource.lastName()),
                    new EmailAddress(resource.contactEmail()),
                    new PhoneNumber(resource.contactPhone()),
                    resource.companyName(), resource.city(), resource.stateOrProvince(), resource.country()
            );

            // 3. Guardar
            Partner saved = partnerRepository.save(partner);

            // 4. Mapear respuesta
            PartnerResource response = new PartnerResource(
                    saved.getId(), saved.getPartnerId().partnerId(),
                    saved.getRepresentativeName().firstName(), saved.getRepresentativeName().lastName(),
                    saved.getContactEmail().address(), saved.getContactPhone().number(),
                    saved.getCompanyName(), saved.getCity(), saved.getStateOrProvince(), saved.getCountry()
            );
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}