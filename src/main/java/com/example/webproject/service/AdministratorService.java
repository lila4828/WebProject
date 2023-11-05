package com.example.webproject.service;

import com.example.webproject.entity.Administrator;

public interface AdministratorService {
    public Administrator getAdmin(String adminId);  // 어드민 값을 가져온다.

    public Administrator changePassword(String adminId, String adminPassword);   // 어드민 비밀번호 변경

}
