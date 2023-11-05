package com.example.webproject.repository;

import com.example.webproject.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<Tag, Long> {
    Long findByTag(String tag);
}