package com.lourence.john.loginsystem.license.service;

import com.lourence.john.loginsystem.license.repository.License;

import java.util.List;

public interface LicenseService {
    License createLicense(License license);
    void deleteAll();
    List<License> getAll();
    License updateLicense(License license);
}
