package com.example.webproject.service;

import com.example.webproject.entity.Book;
import com.example.webproject.entity.Tag;
public interface TagService {

    public Tag getTag(String isbn); // 태그 가져오기

    public Tag saveTag(Book isbn, String tag);  // 태그 생성하기

    public void deleteTag(String isbn); // 태그 지우기

}
