package com.lourence.john.loginsystem.license.resource;

import com.lourence.john.loginsystem.license.repository.License;
import com.lourence.john.loginsystem.license.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/license")
public class LicenseResource {
    @Autowired
    private LicenseService service;

    @PostMapping("/save")
    public License save(@RequestBody License license) {
        return service.createLicense(license);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        service.deleteAll();
    }

    @GetMapping("/getAll")
    public List<License> getAll() {
        return service.getAll();
    }

    @PostMapping("/update")
    public License updateLicense(@RequestBody License license) {
        return service.updateLicense(license);
    }
}
