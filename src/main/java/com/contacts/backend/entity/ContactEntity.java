package com.contacts.backend.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@Setter
@EqualsAndHashCode
@Table(name = "contact", schema = "db_contacts", catalog = "")
public class ContactEntity {

    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String otherInfo;
    private String howFind;

    private String type;
    private String recommender;
    private String conference;
    private String media;
    private String inneMedia;

    private List<AddressEntity> address;
    private CompanyEntity company;
    private PersonEntity person;



    @OneToMany(targetEntity = AddressEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="contact_id", nullable = true, referencedColumnName = "id")
    public List<AddressEntity> getAddress() {
        return address;
    }



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="person_person_id")

    public PersonEntity getPerson() {
        return person;
    }


    @OneToOne(targetEntity = CompanyEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="company_company_id")

    public CompanyEntity getCompany() {
        return company;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "other_info", nullable = true, length = -1)
    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Basic
    @Column(name = "how_find", nullable = true, length = 45)
    public String getHowFind() {
        return howFind;
    }

    public void setHowFind(String howFind) {
        this.howFind = howFind;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 10)
    public String getType() {
        return type;
    }
    @Basic
    @Column(name = "recommender", nullable = true, length = 45)
    public String getRecommender() {
        return recommender;
    }

    @Basic
    @Column(name = "conference", nullable = true, length = 45)
    public String getConference() {
        return conference;
    }

    @Basic
    @Column(name = "media", nullable = true, length = 45)
    public String getMedia() {
        return media;
    }

    @Basic
    @Column(name = "inneMedia", nullable = true, length = 45)
    public String getInneMedia() {
        return inneMedia;
    }

}
