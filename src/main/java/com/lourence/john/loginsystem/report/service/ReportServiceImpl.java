package com.lourence.john.loginsystem.report.service;

import com.lourence.john.loginsystem.report.repository.Report;
import com.lourence.john.loginsystem.report.repository.ReportRepository;
import com.lourence.john.loginsystem.timelog.repository.TimeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository repository;
    @Override
    public List<Report> getReportsById(int id, String startDate, String endDate) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDate+" 00:00:00");
            long start = date.getTime();
            Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDate+" 23:59:59");
            long end = date1.getTime();
            return generateReport(repository.findLogsByEmployeeId(id,start,end));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Report> generateReport(List<TimeLog> timeLogList) {
        List<Report> reportList = new ArrayList<Report>();
        while(!timeLogList.isEmpty()) {
            TimeLog timeIn = (TimeLog)timeLogList.get(0);
            Report report = new Report();
            report.setEmployeeId(timeIn.getEmployeeId());
            report.setTimeIn(timeIn.getTime());
            timeLogList.remove(timeIn);
            TimeLog timeOut = null;
            if(!timeLogList.isEmpty()) {
                timeOut = (TimeLog)timeLogList.get(0);
            }
            if(timeOut!=null && !(timeIn.getType().equals(timeOut.getType()))) {
                report.setTimeOut(timeOut.getTime());
                timeLogList.remove(timeOut);
            } else if(timeOut!=null && timeIn.getType().equals(timeOut.getType())) {
                report.setTimeOut(null);
            } else {
                report.setTimeOut(null);
            }
            reportList.add(report);
        }

        return reportList;
    }

}
