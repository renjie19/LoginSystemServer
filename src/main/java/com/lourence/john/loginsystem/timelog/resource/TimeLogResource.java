package com.lourence.john.loginsystem.timelog.resource;

import com.lourence.john.loginsystem.timelog.repository.TimeLog;
import com.lourence.john.loginsystem.timelog.service.TimeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timeLog")
public class TimeLogResource {
    @Autowired
    private TimeLogService service;

    @PostMapping("/update")
    public TimeLog update(@RequestBody TimeLog timeLog) {
        return service.updateTimeLog(timeLog);
    }
}
