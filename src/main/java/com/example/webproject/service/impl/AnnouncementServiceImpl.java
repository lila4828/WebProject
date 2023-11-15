package com.example.webproject.service.impl;

import com.example.webproject.dto.AnnouncementDto;
import com.example.webproject.entity.Announcement;
import com.example.webproject.repository.AnnouncementRepository;
import com.example.webproject.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @Override
    public List<Announcement> getAnnouncementList() {
        return announcementRepository.findAll();
    }

    @Override
    public void saveAnnouncement(Announcement announcement) {
        announcementRepository.save(announcement);
    }

    @Override
    public void changeNoticeContent(Long id, AnnouncementDto announcementDto) {
        Announcement selectAnnouncement = announcementRepository.findById(id).orElse(null);
        selectAnnouncement.setNoticeTitle(announcementDto.getNoticeTitle());
        selectAnnouncement.setNoticeContent(announcementDto.getNoticeContent());

        announcementRepository.save(selectAnnouncement);
    }

    @Override
    public void deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
    }
}
