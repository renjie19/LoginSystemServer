package com.lourence.john.loginsystem.section.service;

import com.lourence.john.loginsystem.section.repository.Section;

import java.util.List;

public interface SectionService {
    Section createSection(Section section);
    List<Section> getAllSection();
    Section updateSection(Section section);
    void deleteAll();
    void deleteById(int id);
    Section getSectionById(int id);
}
