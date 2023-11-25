package com.example.webproject.controller;

import com.example.webproject.dto.AnnouncementDto;
import com.example.webproject.entity.Announcement;
import com.example.webproject.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/AnnouncementList")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }
    @GetMapping()
    public String viewList(Model model) {
        List<Announcement> announcementList = announcementService.getAnnouncementList();

        model.addAttribute("announcementList", announcementList);

        return "view/Announcement/AnnouncementList";
    }
    @GetMapping("/addAnnouncement")
    public String showAddAnnouncement(Model model) {
        model.addAttribute("announcement", new AnnouncementDto());
        return "view/Announcement/AnnouncementAdd";
    }

    @PostMapping("/addAnnouncement")
    public String addAnnouncement(@ModelAttribute AnnouncementDto announcementDto,
                                  @RequestParam("selectNoticePriority") String NoticePriority ) {
        Announcement announcement = new Announcement();
        announcement.setNoticePriority(NoticePriority);
        announcement.setNoticeTitle(announcementDto.getNoticeTitle());
        announcement.setNoticeContent(announcementDto.getNoticeContent());

        announcementService.saveAnnouncement(announcement);
        return "redirect:/AnnouncementList";
    }

    @GetMapping("viewAnnouncement/{id}")
    public String showAnnouncement(@PathVariable("id") Long AnnouncementId, Model model) {
        Announcement announcement = announcementService.getAnnouncement(AnnouncementId);

        model.addAttribute("announcement", announcement);

        return "view/Announcement/AnnouncementView";
    }

    @GetMapping("/editAnnouncement/{id}")
    public String showEditAnnouncement(@PathVariable("id") Long AnnouncementId, Model model) {
        Announcement announcement = announcementService.getAnnouncement(AnnouncementId);

        model.addAttribute("announcement", announcement);

        return "view/Announcement/AnnouncementEdit";
    }
    @PostMapping("/editAnnouncement/{id}")
    public String editAnnouncement(@PathVariable("id") Long AnnouncementId, @ModelAttribute AnnouncementDto announcementDto)  {
        announcementService.changeNoticeContent(AnnouncementId, announcementDto);

        return "redirect:/AnnouncementList";
    }
    @GetMapping("/deleteAnnouncement/{id}")
    public String deleteAnnouncement(@PathVariable("id") Long AnnouncementId) {
        announcementService.deleteAnnouncement(AnnouncementId);
        return "redirect:/AnnouncementList";
    }
}
