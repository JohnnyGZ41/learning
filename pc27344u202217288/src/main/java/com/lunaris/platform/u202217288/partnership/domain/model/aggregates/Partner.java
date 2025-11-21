package com.lunaris.platform.u202217288.partnership.domain.model.aggregates;

import com.lunaris.platform.u202217288.partnership.domain.model.valueobjects.LunarisPartnerId;
import com.lunaris.platform.u202217288.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.lunaris.platform.u202217288.shared.domain.model.valueobjects.EmailAddress;
import com.lunaris.platform.u202217288.shared.domain.model.valueobjects.PersonName;
import com.lunaris.platform.u202217288.shared.domain.model.valueobjects.PhoneNumber;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Partner extends AuditableAbstractAggregateRoot<Partner> {

    @Embedded
    @AttributeOverride(name = "partnerId", column = @Column(name = "partner_id"))
    private LunarisPartnerId partnerId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "representative_first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "representative_last_name"))
    })
    private PersonName representativeName;

    @Embedded
    @AttributeOverride(name = "address", column = @Column(name = "contact_email"))
    private EmailAddress contactEmail;

    @Embedded
    @AttributeOverride(name = "number", column = @Column(name = "contact_phone"))
    private PhoneNumber contactPhone;

    private String companyName;
    private String city;
    private String stateOrProvince;
    private String country;

    public Partner() {}

    public Partner(PersonName name, EmailAddress email, PhoneNumber phone, String company, String city, String state, String country) {
        this.partnerId = new LunarisPartnerId();
        this.representativeName = name;
        this.contactEmail = email;
        this.contactPhone = phone;
        this.companyName = company;
        this.city = city;
        this.stateOrProvince = state;
        this.country = country;
    }
}