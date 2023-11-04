package com.example.webproject.service.impl;

import com.example.webproject.entity.Administrator;
import com.example.webproject.repository.AdministratorRepository;
import com.example.webproject.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;
    @Autowired
    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public Administrator getAdmin(String adminId) {
        Optional<Administrator> admin = administratorRepository.findById(adminId);
        if(admin.isPresent()) {
            return admin.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Administrator changPassword(String adminId, String newAdminPassword) {
        Optional<Administrator> oldAdmin = administratorRepository.findById(adminId);
        Administrator newAdmin;
        if(oldAdmin.isPresent()) {
            newAdmin = oldAdmin.get();
            newAdmin.setAdminPassword(newAdminPassword);
        } else {
            throw new EntityNotFoundException();
        }
        return newAdmin;
    }
}
