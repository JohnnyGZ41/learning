package com.lunaris.home.partnership.application.internal.commandservices;

import com.lunaris.home.partnership.domain.model.aggregates.Partner;
import com.lunaris.home.partnership.domain.model.commands.CreatePartnerCommand;
import com.lunaris.home.partnership.domain.services.PartnerCommandService;
import com.lunaris.home.partnership.infrastructure.persistence.jpa.repositories.PartnerRepository;
import com.lunaris.home.shared.domain.model.valueobjects.EmailAddress;
import com.lunaris.home.shared.domain.model.valueobjects.PersonName;
import com.lunaris.home.shared.domain.model.valueobjects.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartnerCommandServiceImpl implements PartnerCommandService {

    private final PartnerRepository partnerRepository;

    public PartnerCommandServiceImpl(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    public Optional<Partner> handle(CreatePartnerCommand command) {
        // 1. Regla de Negocio: Verificar duplicados por Nombre + Empresa + País
        var exists = partnerRepository.existsByRepresentativeNameFirstNameAndRepresentativeNameLastNameAndCompanyNameAndCountry(
                command.firstName(),
                command.lastName(),
                command.companyName(),
                command.country()
        );

        if (exists) {
            throw new IllegalArgumentException("Partner with same representative, company and country already exists");
        }

        // 2. Regla de Negocio: Verificar email duplicado (Opcional pero recomendado si es unique en BD)
        // if (partnerRepository.existsByContactEmailAddress(command.email())) { ... }

        // 3. Convertir datos primitivos (Command) a Value Objects (Domain)
        // Aquí saltarán las excepciones si el formato del email o teléfono es inválido
        var name = new PersonName(command.firstName(), command.lastName());
        var email = new EmailAddress(command.email());
        var phone = new PhoneNumber(command.phoneNumber());

        // 4. Crear y Guardar la Entidad
        var partner = new Partner(
                name,
                phone,
                email,
                command.companyName(),
                command.city(),
                command.stateOrProvince(),
                command.country()
        );

        partnerRepository.save(partner);

        return Optional.of(partner);
    }
}