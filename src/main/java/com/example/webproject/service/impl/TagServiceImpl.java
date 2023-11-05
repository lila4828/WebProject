package com.example.webproject.service.impl;

import com.example.webproject.entity.Tag;
import com.example.webproject.repository.TagRepository;
import com.example.webproject.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Long getId(String tag) {
        Long id = tagRepository.findByTag(tag);
        return id;
    }

    @Override
    public String getTag(Long id) {
        Optional<Tag> tag = tagRepository.findById(id);
        if(tag.isPresent()) {
            return tag.get().getTag();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Tag saveTag(String tag) {
        Tag savetag = new Tag();
        savetag.setTag(tag);

        Tag saveTag = tagRepository.save(savetag);
        return saveTag;
    }

    @Override
    public void deleteTag(Long id) {
        Optional<Tag> selectTag = tagRepository.findById(id);
        if(selectTag.isPresent()) {
            Tag deletetag = selectTag.get();
            tagRepository.delete(deletetag);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
