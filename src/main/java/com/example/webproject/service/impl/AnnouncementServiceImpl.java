package com.example.webproject.service.impl;

import com.example.webproject.dto.AnnouncementDto;
import com.example.webproject.entity.Announcement;
import com.example.webproject.repository.AnnouncementRepository;
import com.example.webproject.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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
    public void saveAnnouncement(AnnouncementDto announcementDto) {
        Announcement saveAnnouncement = new Announcement();
        saveAnnouncement.setNoticeTitle(announcementDto.getNoticeTitle());
        saveAnnouncement.setNoticeContent(announcementDto.getNoticeContent());
        announcementRepository.save(saveAnnouncement);
    }

    @Override
    public void changeNoticeContent(Long id, String newNoticeContent) {
        Optional<Announcement> oldAnnouncement = announcementRepository.findById(id);
        Announcement newAnnouncement;
        if(oldAnnouncement.isPresent()) {
            newAnnouncement = oldAnnouncement.get();
            newAnnouncement.setNoticeTitle(newNoticeContent);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void deleteAnnouncement(Long id) {
        Optional<Announcement> selectAnnouncement = announcementRepository.findById(id);
        if(selectAnnouncement.isPresent()) {
            Announcement announcement = selectAnnouncement.get();
            announcementRepository.delete(announcement);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
