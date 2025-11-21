package com.lunaris.home.partnership.domain.model.aggregates;

import com.lunaris.home.partnership.domain.model.valueobjects.LunarisPartnerId;
import com.lunaris.home.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.lunaris.home.shared.domain.model.valueobjects.EmailAddress;
import com.lunaris.home.shared.domain.model.valueobjects.PersonName;
import com.lunaris.home.shared.domain.model.valueobjects.PhoneNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;

@Entity // <--- 1. FALTABA ESTO
@Table(name = "partners") // Recomendado para asegurar plural
@Getter
public class Partner extends AuditableAbstractAggregateRoot<Partner> {

    @Embedded
    @AttributeOverride(name = "uuid", column = @Column(name = "partner_id")) // Asumiendo que LunarisPartnerId tiene un campo 'uuid'
    private LunarisPartnerId partnerId; // <--- 2. camelCase (minúscula al inicio)

    @Embedded
    @AttributeOverrides({
            // 3. Nombres de columna en snake_case estricto (todo minúsculas)
            @AttributeOverride(name = "lastName", column = @Column(name = "representative_last_name", nullable = false)),
            @AttributeOverride(name = "firstName", column = @Column(name = "representative_first_name", nullable = false))
    })
    private PersonName representativeName;

    @Embedded
    // 4. name="number" (el campo dentro del Record PhoneNumber), NO "contactPhone"
    @AttributeOverride(name = "number", column = @Column(name = "contact_phone", nullable = false))
    private PhoneNumber contactPhone;

    @Embedded
    // 5. name="address" (el campo dentro del Record EmailAddress), NO "contactEmail"
    @AttributeOverride(name = "address", column = @Column(name = "contact_email", nullable = false))
    private EmailAddress contactEmail;

    @Column(name = "company_name") // Recomendado explicitar snake_case
    private String companyName;

    private String city;

    @Column(name = "state_or_province") // Recomendado explicitar snake_case
    private String stateOrProvince;

    private String country;

    // Constructor vacío requerido por JPA
    protected Partner() {}

    public Partner(
            PersonName representativeName,
            PhoneNumber contactPhone,
            EmailAddress contactEmail,
            String companyName,
            String city,
            String stateOrProvince,
            String country
    ) {
        this.partnerId = new LunarisPartnerId(); // Generación automática
        this.representativeName = representativeName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.companyName = companyName;
        this.city = city;
        this.stateOrProvince = stateOrProvince;
        this.country = country;
    }
}