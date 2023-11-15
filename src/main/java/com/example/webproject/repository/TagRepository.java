package com.example.webproject.repository;

import com.example.webproject.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByTag(String tag);          // 태그 이름으로 tag 찾기
}