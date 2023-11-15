package com.example.webproject.service.impl;

import com.example.webproject.entity.Tag;
import com.example.webproject.repository.TagRepository;
import com.example.webproject.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public String getTag(Long isbn) {
        Tag tag = tagRepository.findById(isbn).orElse(null);

        return tag.getTag();
    }

    @Override
    public Tag getTagByName(String tag) {
      return tagRepository.findByTag(tag);
    }

    @Override
    public void saveTag(Tag tag) {
        tagRepository.save(tag);
    }
}
