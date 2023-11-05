package com.example.webproject.service;

import com.example.webproject.entity.Announcement;

public interface AnnouncementService {
    public Announcement getAnnouncement(Long id);   // 공지사항을 가져온다.

    public Announcement saveAnnouncement(Announcement announcement);    // 공지사항 쓰기

    public Announcement changeNoticeContent(Long id, String newNoticeContent);   // 공지사항 내용변경

    public void deleteAnnouncement(Long id);    // 공지사항 지우기
}
