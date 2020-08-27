package com.contacts.backend.repositories;

import com.contacts.backend.entity.ContactEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

    Page<ContactEntity> findAll(Pageable pageable);
    @Query("SELECT c FROM ContactEntity c where " +
            "(:name is null or :name='' or lower(c.name) like lower(concat('%', :name,'%'))) and" +
            "(:type is null or :type='' or lower(c.type) like lower(concat('%', :type,'%'))) and" +
            "(:email is null or :email='' or lower(c.email) like lower(concat('%', :email,'%'))) and" +
            "(:phone is null or :phone='' or lower(c.phone) like lower(concat('%', :phone,'%')))"

    )
    Page<ContactEntity> findByParams(@Param("name") String name,
                                     @Param("type") String type,
                                     @Param("email") String email,
                                     @Param("phone") String phone,
                                     Pageable pageable);

}
