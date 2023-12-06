package com.example.webproject.controller;

import com.example.webproject.dto.AnnouncementDto;
import com.example.webproject.entity.Announcement;
import com.example.webproject.entity.Member;
import com.example.webproject.service.AnnouncementService;
import com.example.webproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/AnnouncementList")
public class AnnouncementController {
    private final AnnouncementService announcementService;
    private final MemberService memberService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService, MemberService memberService) {
        this.announcementService = announcementService;
        this.memberService = memberService;
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
                                  @RequestParam("selectNoticePriority") String NoticePriority,
                                  Principal principal) {
        Announcement announcement = new Announcement();
        announcement.setNoticePriority(NoticePriority);
        announcement.setNoticeTitle(announcementDto.getNoticeTitle());
        announcement.setNoticeContent(announcementDto.getNoticeContent());

        Member member = memberService.getMember(principal.getName());
        announcement.setMemberId(member);

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
}
