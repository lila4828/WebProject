package com.example.webproject.repository;

import com.example.webproject.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Long findByTag(String tag);
}