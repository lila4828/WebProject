package com.example.webproject.service.impl;

import com.example.webproject.entity.Book;
import com.example.webproject.entity.Tag;
import com.example.webproject.repository.TagRepository;
import com.example.webproject.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag getTag(String isbn) {
        Optional<Tag> tag = tagRepository.findById(isbn);
        if(tag.isPresent()) {
            return tag.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Tag saveTag(Book isbn, String tag) {

        Tag savetag = new Tag();
        savetag.setIsbn(isbn);
        savetag.setTag(tag);

        Tag saveTag = tagRepository.save(savetag);
        System.out.println(saveTag);
        return saveTag;
    }

    @Override
    public void deleteTag(String isbn) {
        Optional<Tag> selectTag = tagRepository.findById(isbn);
        if(selectTag.isPresent()) {
            Tag tag = selectTag.get();
            tagRepository.delete(tag);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
