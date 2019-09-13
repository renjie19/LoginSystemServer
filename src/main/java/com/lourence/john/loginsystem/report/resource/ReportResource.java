package com.lourence.john.loginsystem.report.resource;

import com.lourence.john.loginsystem.report.repository.Report;
import com.lourence.john.loginsystem.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportResource {
    @Autowired
    private ReportService service;

    @GetMapping("/viewByEmployeeId")
    public List<Report> viewReport(@RequestParam int id, @RequestParam String startDate, @RequestParam String endDate) {
        return service.getReportsById(id,startDate,endDate);
    }

}
