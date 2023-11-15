package com.example.webproject.service;

import com.example.webproject.entity.Tag;

public interface TagService {

    public String getTag(Long id);          // id로 태그 가져오기

    public Tag getTagByName(String tag);    // 이름으로 태그 가져오기

    public void saveTag(Tag tag);            // 태그 저장하기

}
