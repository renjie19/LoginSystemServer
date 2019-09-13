package com.lourence.john.loginsystem.section.resource;

import com.lourence.john.loginsystem.section.repository.Section;
import com.lourence.john.loginsystem.section.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/section")
public class SectionResource {
    @Autowired
    private SectionService service;

    @PostMapping("/save")
    public Section save(@RequestBody Section section) {
        return service.createSection(section);
    }

    @PostMapping("/update")
    public Section update(@RequestBody Section section) {
        return service.updateSection(section);
    }

    @GetMapping("/getAll")
    public List<Section> getAll() {
        return service.getAllSection();
    }

    @GetMapping("/getById")
    public Section getById(@RequestParam int id) {
        return service.getSectionById(id);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam int id) {
        service.deleteById(id);
    }


}
