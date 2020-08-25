package com.contacts.backend.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@EqualsAndHashCode
@Table(name = "address", schema = "db_contacts", catalog = "")
public class AddressEntity {
    private Integer addressId;
    private String addressType;
    private String addressStreet;
    private String addressHome;
    private String addressApartment;
    private String addressPostalCode;
    private String addressCity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    public Integer getAddressId() {
        return addressId;
    }

    @Basic
    @Column(name = "address_type", nullable = true, length = 64)
    public String getAddressType() {
        return addressType;
    }

    @Basic
    @Column(name = "address_street", nullable = true, length = 64)
    public String getAddressStreet() {
        return addressStreet;
    }

    @Basic
    @Column(name = "address_home", nullable = true, length = 10)
    public String getAddressHome() {
        return addressHome;
    }

    @Basic
    @Column(name = "address_apartment", nullable = true, length = 10)
    public String getAddressApartment() {
        return addressApartment;
    }

    @Basic
    @Column(name = "address_postal_code", nullable = true, length = 6)
    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    @Basic
    @Column(name = "address_city", nullable = true, length = 255)
    public String getAddressCity() {
        return addressCity;
    }

}
