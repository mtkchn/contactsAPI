package com.contacts.backend.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@EqualsAndHashCode
@Table(name = "person", schema = "db_contacts")
public class PersonEntity {
    private Integer personId;
    private String surname;
    private Long pesel;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    public Integer getPersonId() {
        return personId;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }

    @Basic
    @Column(name = "pesel", nullable = false)
    public Long getPesel() {
        return pesel;
    }

}
