package com.lourence.john.loginsystem.subject.service;

import com.lourence.john.loginsystem.subject.repository.Subject;
import com.lourence.john.loginsystem.subject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository repository;

    @Override
    public Subject createSubject(Subject subject) {
        return repository.save(subject);
    }

    @Override
    public List<Subject> getAll() {
        List<Subject> subjectList = new ArrayList<>();
        Iterable<Subject> subjectIterable = repository.findAll();
        for (Subject subject : subjectIterable) {
            subjectList.add(subject);
        }
        return subjectList;
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
