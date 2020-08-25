package com.contacts.backend.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@EqualsAndHashCode
@Table(name = "company", schema = "db_contacts", catalog = "")
public class CompanyEntity {
    private Integer companyId;
    private Long nip;
    private Long regon;
    private Integer krs;
    private String legalForm;
    private String otherLegalForm;

    private ContactEntity contactByContactId;
    private List<EmployeeEntity> employee;

    @OneToMany(targetEntity = EmployeeEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="company_company_id", nullable = true, referencedColumnName = "company_id")
    public List<EmployeeEntity> getEmployee() {
        return employee;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    public Integer getCompanyId() {
        return companyId;
    }

    @Basic
    @Column(name = "nip", nullable = false)
    public Long getNip() {
        return nip;
    }

    @Basic
    @Column(name = "regon", nullable = false)
    public Long getRegon() {
        return regon;
    }

    @Basic
    @Column(name = "krs", nullable = false)
    public Integer getKrs() {
        return krs;
    }

    @Basic
    @Column(name = "legal_form", nullable = false, length = 45)
    public String getLegalForm() {
        return legalForm;
    }

    @Basic
    @Column(name = "other_legal_form",  length = 45)
    public String getOtherLegalForm() {
        return otherLegalForm;
    }



}
