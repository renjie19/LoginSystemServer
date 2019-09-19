package com.lourence.john.loginsystem.report.service;

import com.lourence.john.loginsystem.report.repository.Report;
import com.lourence.john.loginsystem.report.repository.ReportRepository;
import com.lourence.john.loginsystem.timelog.repository.TimeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
            //return generateReport(repository.findLogsByEmployeeId(id,start,end));
            return generateReport(repository.findByEmployeeIdAndTimeBetweenOrderByTimeAsc(id,start,end));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Report> generateReport(List<TimeLog> timeLogList) {
        List<Report> reportList = new ArrayList<>();
        while(!timeLogList.isEmpty()) {
            Report report = new Report();
            report.setTimeInLog(timeLogList.get(0));
            timeLogList.remove(report.getTimeInLog());
            TimeLog timeOut = null;
            if(!timeLogList.isEmpty()) {
                timeOut = timeLogList.get(0);
            }
            if(timeOut!=null && !(report.getTimeInLog().getType().equals(timeOut.getType()))) {
                report.setTimeOutLog(timeLogList.get(0));
                report.setTotalHours(getHoursRendered(report));
                timeLogList.remove(timeOut);
            } else if(timeOut!=null && report.getTimeInLog().getType().equals(timeOut.getType())) {
                report.setTimeOutLog(null);
            } else {
                report.setTimeOutLog(null);
            }
            reportList.add(report);
        }
        return reportList;
    }

    private double getHoursRendered(Report report){
        if(report.getTimeInLog().getTime() != 0 && report.getTimeOutLog().getTime() != 0) {
            Long timeIn = report.getTimeInLog().getTime();
            Long timeOut = report.getTimeOutLog().getTime();
            Long diff = timeOut - timeIn;
            BigDecimal bigDecimal = new BigDecimal(Double.toString(((double)diff/1000)/3600));
            bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
            return bigDecimal.doubleValue();
        }
        return 0;
    }

}
