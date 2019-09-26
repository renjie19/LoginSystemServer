package com.lourence.john.loginsystem.license.service;

import com.lourence.john.loginsystem.license.repository.License;
import com.lourence.john.loginsystem.license.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LicenseServiceImpl implements LicenseService {
    @Autowired
    private LicenseRepository repository;

    @Override
    public License createLicense(License license) {
        return repository.save(license);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public List<License> getAll() {
        return repository.findAll();
    }

    @Override
    public License updateLicense(License license) {
        return repository.save(license);
    }
}
