package com.lourence.john.loginsystem.report.repository;


import com.lourence.john.loginsystem.timelog.repository.TimeLog;

import java.util.Date;

public class Report {
    private int employeeId;
    private TimeLog timeInLog;
    private  TimeLog timeOutLog;
    private double totalHours;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public TimeLog getTimeInLog() {
        return timeInLog;
    }

    public void setTimeInLog(TimeLog timeInLog) {
        this.timeInLog = timeInLog;
        this.employeeId = timeInLog.getEmployeeId();
    }

    public TimeLog getTimeOutLog() {
        return timeOutLog;
    }

    public void setTimeOutLog(TimeLog timeOutLog) {
        this.timeOutLog = timeOutLog;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }
}
