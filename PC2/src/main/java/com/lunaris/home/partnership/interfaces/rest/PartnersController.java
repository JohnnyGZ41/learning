package com.lunaris.home.partnership.interfaces.rest;

import com.lunaris.home.partnership.domain.services.PartnerCommandService;
import com.lunaris.home.partnership.interfaces.rest.resources.CreatePartnerResource;
import com.lunaris.home.partnership.interfaces.rest.resources.PartnerResource;
import com.lunaris.home.partnership.interfaces.rest.transform.CreatePartnerCommandFromResourceAssembler;
import com.lunaris.home.partnership.interfaces.rest.transform.PartnerResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/partners", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Partners", description = "Available Partner Endpoints")
public class PartnersController {

    private final PartnerCommandService partnerCommandService;

    public PartnersController(PartnerCommandService partnerCommandService) {
        this.partnerCommandService = partnerCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a Partner", description = "Creates a new Partner in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Partner created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<PartnerResource> createPartner(@RequestBody CreatePartnerResource resource) {
        var command = CreatePartnerCommandFromResourceAssembler.toCommandFromResource(resource);
        var partner = partnerCommandService.handle(command);

        if (partner.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var partnerResource = PartnerResourceFromEntityAssembler.toResourceFromEntity(partner.get());
        return new ResponseEntity<>(partnerResource, HttpStatus.CREATED);
    }
}