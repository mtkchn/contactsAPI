package com.contacts.backend.controller;

import com.contacts.backend.entity.ContactEntity;
import com.contacts.backend.entity.EmployeeEntity;
import com.contacts.backend.repositories.EmploeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmploeeRepository emploeeRepository;


    @GetMapping("/employee")
    public List<EmployeeEntity> emploee() {
        List<EmployeeEntity> list = emploeeRepository.findAll();
        System.out.println("employee = " + list);
        return list;
    }

    @PostMapping("/addemployee")
    public void add(@RequestBody EmployeeEntity emploee) {
        emploeeRepository.save(emploee);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {

        try {
            emploeeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/employee/update")
    public ResponseEntity<EmployeeEntity> update(@RequestBody EmployeeEntity employee) {

        if (employee.getEmployeeId() == null || employee.getEmployeeId() == 0) {
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }
        emploeeRepository.save(employee);
        return new ResponseEntity(HttpStatus.OK); //
    }

}
