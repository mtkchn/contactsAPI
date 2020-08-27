package com.contacts.backend.repositories;

import com.contacts.backend.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
