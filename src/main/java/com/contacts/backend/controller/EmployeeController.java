package com.contacts.backend.controller;

import com.contacts.backend.entity.EmployeeEntity;
import com.contacts.backend.repositories.EmploeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmploeeRepository emploeeRepository;



    @GetMapping("/emploee")
    public List<EmployeeEntity> emploee(){
        List<EmployeeEntity> list = emploeeRepository.findAll();
        System.out.println("emploee = " + list);
        return list;
    }

    @PostMapping("/addemploee")
    public void add(@RequestBody EmployeeEntity emploee){
        emploeeRepository.save(emploee);
    }
}
