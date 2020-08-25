package com.contacts.backend.controller;

import com.contacts.backend.entity.ContactEntity;
import com.contacts.backend.repositories.ContactRepository;
import com.contacts.backend.search.ContactsSearchValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/contact")
    public Page<ContactEntity> contact(@RequestBody ContactsSearchValues contactsSearchValues) {

        PageRequest pageRequest = PageRequest.of(contactsSearchValues.getPageNumber(), contactsSearchValues.getPageSize());
        Page<ContactEntity> page = contactRepository.findAll(pageRequest);
        return page;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/contact/add")
    public void add(@RequestBody ContactEntity person) {
        contactRepository.save(person);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/contact/{id}")
    public Optional<ContactEntity> findById(@PathVariable Integer id) {
         Optional<ContactEntity> contact = contactRepository.findById(id);
        return contact;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/contact/update")
    public ResponseEntity<ContactEntity> update(@RequestBody ContactEntity person) {
        
        if (person.getId() == null || person.getId() == 0) {
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }
        contactRepository.save(person);
        return new ResponseEntity(HttpStatus.OK); //
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/contact/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {

        try {
            contactRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}

