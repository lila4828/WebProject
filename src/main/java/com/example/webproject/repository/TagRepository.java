package com.example.webproject.repository;

import com.example.webproject.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByTag(String tag);
}