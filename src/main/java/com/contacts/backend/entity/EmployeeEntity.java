package com.contacts.backend.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@EqualsAndHashCode
@Table(name = "employee", schema = "db_contacts", catalog = "")
public class EmployeeEntity {
    private Integer employeeId;
    private String employeeName;
    private String employeeSurname;
    private String employeePosition;
    private String employeePhone;
    private Byte employeeStatus;
    private ContactEntity contactByContactId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    public Integer getEmployeeId() {
        return employeeId;
    }

    @Basic
    @Column(name = "employee_name", nullable = true, length = 45)
    public String getEmployeeName() {
        return employeeName;
    }

    @Basic
    @Column(name = "employee_surname", nullable = true, length = 45)
    public String getEmployeeSurname() {
        return employeeSurname;
    }

    @Basic
    @Column(name = "employee_position", nullable = true, length = 45)
    public String getEmployeePosition() {
        return employeePosition;
    }

    @Basic
    @Column(name = "employee_phone", nullable = true, length = 20)
    public String getEmployeePhone() {
        return employeePhone;
    }

    @Basic
    @Column(name = "employee_status", nullable = true)
    public Byte getEmployeeStatus() {
        return employeeStatus;
    }

}
