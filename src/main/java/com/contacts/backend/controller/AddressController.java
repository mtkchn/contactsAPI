package com.contacts.backend.controller;


import com.contacts.backend.entity.AddressEntity;
import com.contacts.backend.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/adress")
    public List<AddressEntity> adress() {
        List<AddressEntity> list = addressRepository.findAll();
        System.out.println("adress = " + list);
        return list;
    }

    @PostMapping("/addadress")
    public void add(@RequestBody AddressEntity adress){
        
        addressRepository.save(adress);
    }
}
