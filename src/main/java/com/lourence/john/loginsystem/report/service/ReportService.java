package com.lourence.john.loginsystem.report.service;

import com.lourence.john.loginsystem.report.repository.Report;

import java.util.List;

public interface ReportService {
    List<Report> getReportsById(int id, String startDate, String endDate);
}
