package com.example.webproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnouncementDto {
    private String noticePriority;      // 긴급 공지 유무
    private String noticeTitle;         // 공지사항 제목
    private String noticeContent;       // 공지사항 내용
}
