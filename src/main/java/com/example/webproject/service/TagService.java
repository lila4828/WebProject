package com.example.webproject.service;

import com.example.webproject.entity.Tag;


public interface TagService {

    public Long getId(String tag); // 태그로 id 가져오기

    public String getTag(Long id);  // id로 태그 가져오기

    public Tag saveTag(String tag);  // 태그 생성하기

    public void deleteTag(Long id); // 태그 지우기

}
