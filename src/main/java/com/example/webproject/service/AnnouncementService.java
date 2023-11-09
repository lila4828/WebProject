package com.example.webproject.service;

import com.example.webproject.dto.AnnouncementDto;
import com.example.webproject.entity.Announcement;

import java.util.List;

public interface AnnouncementService {
    public List<Announcement> getAnnouncementList();   // 공지사항을 가져온다.

    public void saveAnnouncement(AnnouncementDto announcementDto);    // 공지사항 쓰기

    public void changeNoticeContent(Long id, String newNoticeContent);   // 공지사항 내용변경

    public void deleteAnnouncement(Long id);    // 공지사항 지우기
}
