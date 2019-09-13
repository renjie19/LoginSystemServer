package com.lourence.john.loginsystem.subject.service;

import com.lourence.john.loginsystem.subject.repository.Subject;

import java.util.List;

public interface SubjectService {
    Subject createSubject(Subject subject);
    List<Subject> getAll();
}
