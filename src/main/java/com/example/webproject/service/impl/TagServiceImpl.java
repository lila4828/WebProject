package com.example.webproject.service.impl;

import com.example.webproject.entity.Book;
import com.example.webproject.entity.Tag;
import com.example.webproject.repository.TagRepository;
import com.example.webproject.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public String getTag(Long isbn) {
        Optional<Tag> tag = tagRepository.findById(isbn);
        if(tag.isPresent()) {
            return tag.get().getTag();
        } else {
            throw new EntityNotFoundException();
        }
    }

}
