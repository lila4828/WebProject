package com.example.webproject.repository;

import com.example.webproject.entity.Administrator;
import com.example.webproject.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, String> {

}
