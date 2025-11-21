package com.lunaris.home.partnership.infrastructure.persistence.jpa.repositories;


import com.lunaris.home.partnership.domain.model.aggregates.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
    boolean existsByRepresentativeNameFirstNameAndRepresentativeNameLastNameAndCompanyNameAndCountry(
            String firstName,
            String lastName,
            String companyName,
            String country
    );
}
