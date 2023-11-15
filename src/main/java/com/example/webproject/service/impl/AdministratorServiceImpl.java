package com.example.webproject.service.impl;

import com.example.webproject.entity.Administrator;
import com.example.webproject.repository.AdministratorRepository;
import com.example.webproject.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;
    @Autowired
    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public boolean checkAdmin(String adminId, String adminPassword) {
        Administrator selectAdmin = administratorRepository.findById(adminId).orElse(null);

        if (selectAdmin.getAdminPassword().equals(adminPassword)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void changePassword(String adminId, String newAdminPassword) {
        Administrator selectAdmin = administratorRepository.findById(adminId).orElse(null);

        selectAdmin.setAdminPassword(newAdminPassword);
        administratorRepository.save(selectAdmin);
    }
}
