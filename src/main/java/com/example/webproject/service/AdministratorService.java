package com.example.webproject.service;

import com.example.webproject.entity.Administrator;

public interface AdministratorService {

    public boolean checkAdmin(String adminId, String adminPassword); // 어드민 인지 확인한다.

    public Administrator changePassword(String adminId, String adminPassword);   // 어드민 비밀번호 변경

}
