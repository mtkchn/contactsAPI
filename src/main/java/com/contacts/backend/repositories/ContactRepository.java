package com.contacts.backend.repositories;

import com.contacts.backend.entity.ContactEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

    Page<ContactEntity> findAll(Pageable pageable);
}
