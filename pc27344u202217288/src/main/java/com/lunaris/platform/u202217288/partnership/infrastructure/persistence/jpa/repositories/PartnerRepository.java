package com.lunaris.platform.u202217288.partnership.infrastructure.persistence.jpa.repositories;

import com.lunaris.platform.u202217288.partnership.domain.model.aggregates.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    boolean existsByRepresentativeName_FirstNameAndRepresentativeName_LastNameAndCompanyNameAndCountry(
            String firstName, String lastName, String companyName, String country
    );
}