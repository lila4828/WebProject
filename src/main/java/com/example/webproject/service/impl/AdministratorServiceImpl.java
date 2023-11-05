package com.example.webproject.service.impl;

import com.example.webproject.entity.Administrator;
import com.example.webproject.repository.AdministratorRepository;
import com.example.webproject.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;
    @Autowired
    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public boolean checkAdmin(String adminId, String adminPassword) {
        // 작성 중
        return false;
    }

    @Override
    public Administrator changePassword(String adminId, String newAdminPassword) {
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
