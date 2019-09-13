package com.lourence.john.loginsystem.util.employeetimelogfacade;

import com.lourence.john.loginsystem.employee.service.EmployeeService;
import com.lourence.john.loginsystem.timelog.repository.TimeLog;
import com.lourence.john.loginsystem.timelog.service.TimeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTimeLogFacade {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TimeLogService timeLogService;

    public TimeLog logTime(int id) {
        try {
            employeeService.hasId(id);
            return timeLogService.createTimeLog(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
