package com.lourence.john.loginsystem.subject.resource;

import com.lourence.john.loginsystem.subject.repository.Subject;
import com.lourence.john.loginsystem.subject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectResource {
    @Autowired
    private SubjectService service;

    @PostMapping("/save")
    public Subject save(@RequestBody Subject subject) {
        return service.createSubject(subject);
    }

    @GetMapping("/getAll")
    public List<Subject> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam int id) {
        service.deleteById(id);
    }
}
