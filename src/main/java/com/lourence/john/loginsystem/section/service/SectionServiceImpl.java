package com.lourence.john.loginsystem.section.service;

import com.lourence.john.loginsystem.section.repository.Section;
import com.lourence.john.loginsystem.section.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SectionServiceImpl implements SectionService  {
    @Autowired
    private SectionRepository repository;

    @Override
    public Section createSection(Section section) {
        return repository.save(section);
    }

    @Override
    public List<Section> getAllSection() {
        List<Section> sectionList = new ArrayList<>();
        Iterable<Section> sectionIterable = repository.findAll();
        for(Section section : sectionIterable) {
            sectionList.add(section);
        }
        return sectionList;
    }

    @Override
    public Section updateSection(Section section) {
        return repository.save(section);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Section getSectionById(int id) {
        Optional<Section> optionalSection = repository.findById(id);
        return optionalSection.orElse(null);
    }
}
